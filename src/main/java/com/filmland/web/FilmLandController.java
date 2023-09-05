package com.filmland.web;

import com.filmland.constant.Constants;
import com.filmland.constant.FilmLandPath;
import com.filmland.custom.*;
import com.filmland.domain.Customer;
import com.filmland.domain.SubscribedCategories;
import com.filmland.exception.FilmLandException;
import com.filmland.service.CategoryService;
import com.filmland.service.FilmLandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.filmland.constant.FilmLandPath.FILMLAND;

/**
 * Rest controller for FilmLand APIs
 */
@RestController
@RequestMapping(FILMLAND)
public class FilmLandController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilmLandController.class);

    @Autowired
    FilmLandService filmLandService;

    @Autowired
    CategoryService categoryService;

    @PostMapping(path = FilmLandPath.SIGNUP, consumes = "application/json", produces = "application/json")
    public ResponseEntity<FilmLandResponse> addUser(@RequestBody LoginCustomerRequest user) {

        boolean result;
        FilmLandResponse messageResponse;
        try {

            result = filmLandService.saveUser(user);
            if (result) {
                messageResponse = new FilmLandResponse(HttpStatus.OK.toString(), Constants.SUCCESSFULLY_CREATED);
                return new ResponseEntity<>(messageResponse, HttpStatus.OK);
            } else {
                messageResponse = new FilmLandResponse(HttpStatus.CONFLICT.toString(), Constants.EXIST);
                return new ResponseEntity<>(messageResponse, HttpStatus.CONFLICT);
            }
        } catch (FilmLandException e) {
            LOGGER.error(e.getMessage());
        }
        return new ResponseEntity<>(new FilmLandResponse(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED.toString(), Constants.BANDWIDTH), HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }

    @PostMapping(path = FilmLandPath.LOGIN, consumes = "application/json", produces = "application/json")
    public ResponseEntity<FilmLandResponse> checkLoginCredentials(@RequestBody LoginCustomerRequest user) {
        boolean result;
        FilmLandResponse messageResponse;
        try {
            result = filmLandService.validateUser(user);
            if (result) {
                messageResponse = new FilmLandResponse(HttpStatus.OK.toString(), Constants.SUCCESSFUL_LOGIN);
                return new ResponseEntity<>(messageResponse, HttpStatus.OK);
            } else {
                messageResponse = new FilmLandResponse(HttpStatus.CONFLICT.toString(), Constants.UNSUCCESSFUL_LOGIN);
                return new ResponseEntity<>(messageResponse, HttpStatus.CONFLICT);
            }
        } catch (FilmLandException e) {
            LOGGER.error(e.getMessage());
        }
        return new ResponseEntity<>(new FilmLandResponse(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED.toString(), Constants.BANDWIDTH), HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }

    @GetMapping(path = FilmLandPath.DETAILS)
    public ResponseEntity<CategoryResponse> getCustomerCategories(@RequestParam(value = "name") String name) {
        Customer customer = filmLandService.getCustomerByName(name);
        String userName = customer != null ? customer.getName() : "";
        if (userName != null && !userName.isEmpty()) {
            if (name != null) {
                LOGGER.info("Categories: {} Successfully fetched all Categories",
                        categoryService.fetchAvailableCategories(userName));
                return new ResponseEntity<>(categoryService.fetchAvailableCategories(userName), HttpStatus.OK);
            } else {
                LOGGER.info("Categories: No Categories to be fetched");
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } else {
            LOGGER.error("Categories: {} Not Authorized ", Constants.UNAUTHORIZED_MESSAGE);
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping(path = FilmLandPath.SUBSCRIBE, consumes = "application/json", produces = "application/json")
    public ResponseEntity<FilmLandResponse> checkCustomerCanSubscribeACategory(@RequestBody NewSubscriptionRequest subscription, @RequestParam(value = "name") String name) {
        Customer customer = filmLandService.getCustomerByName(name);
        String userName = customer != null ? customer.getName() : "";
        FilmLandResponse messageResponse;
        if (!userName.isEmpty()) {
            boolean isAlreadyExists = Boolean.FALSE;

            List<SubscribedCategories> subscribedCategoryByName = (List<SubscribedCategories>) categoryService.getSubscribedCategoryByName(userName);
            for (SubscribedCategories subscribedService : subscribedCategoryByName) {
                if (subscription.getName().equals(subscribedService.getUserName())) {
                    isAlreadyExists = true;
                    break;
                }
            }
            if (!isAlreadyExists) {
                SubscribedCategories subscribedCategories = new SubscribedCategories(userName, subscription.getName(), "1",
                        Double.valueOf("10"), LocalDateTime.now(), LocalDateTime.now());
                categoryService.saveSubscribedCategory(subscribedCategories);
                messageResponse = new FilmLandResponse("Success" + HttpStatus.OK,
                        " Subscription item " + subscribedCategories.getName() + " has been added to the bucket list of "
                                + subscribedCategories.getUserName());
                LOGGER.info("Categories: {} Successfully subscribed categories ", subscribedCategories.getUserName());
                return new ResponseEntity<>(messageResponse, HttpStatus.OK);
            } else {
                messageResponse = new FilmLandResponse("Failed" + HttpStatus.CONFLICT,
                        "Requested Subscription is already subscribed");
                LOGGER.warn("Categories: Requested Subscription is already subscribed ");
                return new ResponseEntity<>(messageResponse, HttpStatus.CONFLICT);
            }
        } else {
            messageResponse = new FilmLandResponse("Failed" + HttpStatus.UNAUTHORIZED, Constants.UNAUTHORIZED_MESSAGE);
            LOGGER.error("Categories: {} Not Authorized ", Constants.UNAUTHORIZED_MESSAGE);
            return new ResponseEntity<>(messageResponse, HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping(path = FilmLandPath.SHARESUBSCRIBE, consumes = "application/json", produces = "application/json")
    public ResponseEntity<FilmLandResponse> checkCustomerCanShareASubscription(@RequestBody ShareSubscriptionRequest shareSubscriptionRequest, @RequestParam(value = "name") String name) {
        Customer customer = filmLandService.getCustomerByName(name);
        String userName = customer != null ? customer.getName() : "";
        Customer registeredDetails = filmLandService.getDetailsByFriendName(shareSubscriptionRequest.getFriendName());
        FilmLandResponse messageResponse;
        if (null != registeredDetails) {
            if (!userName.isEmpty()) {
                boolean isExists = Boolean.FALSE;
                List<SubscribedCategories> subscribedCategoriesResponseList = (List<SubscribedCategories>) categoryService
                        .getSubscribedCategoryByName(userName);
                for (SubscribedCategories subscribedCategoriesResponse : subscribedCategoriesResponseList) {
                    if (shareSubscriptionRequest.getCategoryName().equals(subscribedCategoriesResponse.getUserName())) {
                        isExists = true;
                        break;
                    }
                }
                if (isExists) {
                    categoryService.updateSubscribedCategory(shareSubscriptionRequest.getFriendName(),
                            shareSubscriptionRequest.getCategoryName(), userName);
                    messageResponse = new FilmLandResponse("Success" + HttpStatus.OK,
                            " Successfully shared the item to " + shareSubscriptionRequest.getFriendName());
                    LOGGER.info("Categories: {} Successfully shared the categories ",
                            shareSubscriptionRequest.getFriendName());
                    return new ResponseEntity<>(messageResponse, HttpStatus.OK);
                } else {
                    messageResponse = new FilmLandResponse("Not Available" + HttpStatus.BAD_REQUEST,
                            "Requested Subscription is not available with the existing subscriber :" + userName);
                    LOGGER.warn("Categories: Requested Subscription is not available with the existing subscriber");
                    return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
                }
            } else {
                messageResponse = new FilmLandResponse("Failed" + HttpStatus.UNAUTHORIZED,
                        Constants.UNAUTHORIZED_MESSAGE);
                LOGGER.error("Categories: {} Not Authorized ", Constants.UNAUTHORIZED_MESSAGE);
                return new ResponseEntity<>(messageResponse, HttpStatus.UNAUTHORIZED);
            }
        } else {
            messageResponse = new FilmLandResponse("Failed" + HttpStatus.BAD_REQUEST,
                    "Requested friend not available");
            LOGGER.error("Categories: {} Requested friend not available ",
                    shareSubscriptionRequest.getFriendName());
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
