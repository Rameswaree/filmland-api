package com.filmland.service;

import com.filmland.custom.LoginCustomerRequest;
import com.filmland.domain.Customer;
import com.filmland.exception.FilmLandException;
import com.filmland.repository.FilmLandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmLandServiceImpl implements FilmLandService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilmLandServiceImpl.class);
    @Autowired
    private FilmLandRepository filmLandRepository;

    @Override
    public boolean saveUser(LoginCustomerRequest loginCustomerRequest) {

        try {
            Customer customer = new Customer();
            customer.setEmail(loginCustomerRequest.getEmail());
            customer.setName(loginCustomerRequest.getName());
            customer.setPassword(loginCustomerRequest.getPassword());
            filmLandRepository.save(customer);
        } catch (Exception e) {
            LOGGER.error("Specific Email ID: {} Exists", loginCustomerRequest.getEmail());
            return false;
        }
        LOGGER.info("User Email ID: {}  Successfully registered in the database", loginCustomerRequest.getEmail());
        return true;
    }

    @Override
    public boolean validateUser(LoginCustomerRequest loginCustomerRequest) throws FilmLandException {
        try {
            Customer customer = new Customer();
            customer.setEmail(loginCustomerRequest.getEmail());
            customer.setPassword(loginCustomerRequest.getPassword());
            List<Customer> userList = filmLandRepository.findAll();
            for (Customer userLogin : userList) {
                if (loginCustomerRequest.getEmail().equals(userLogin.getEmail())
                        && loginCustomerRequest.getPassword().equals(userLogin.getPassword())) {
                    LOGGER.info("User: {} Successfully logged in", loginCustomerRequest.getEmail());
                    return true;
                }
            }
        } catch (Exception e) {
            if (e.getMessage() != null) {
                throw new FilmLandException(e.getMessage());
            }
        }
        LOGGER.info("User: {} Failed logged in", loginCustomerRequest.getEmail());
        return false;
    }

    @Override
    public Customer getCustomerByName(String name) {
        return filmLandRepository.findByName(name);
    }

    @Override
    public Customer getDetailsByFriendName(String friendName) {
        return filmLandRepository.findByName(friendName);
    }
}
