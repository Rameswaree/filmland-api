package com.filmland.service;

import com.filmland.custom.AvailableCategoriesResponse;
import com.filmland.custom.CategoryResponse;
import com.filmland.custom.SubscribedCategoriesResponse;
import com.filmland.domain.SubscribedCategories;
import com.filmland.repository.AvailableCategoriesRepository;
import com.filmland.repository.SubscribedCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private AvailableCategoriesRepository availableCategoriesRepository;

    @Autowired
    private SubscribedCategoriesRepository subscribedCategoriesRepository;

    /**
     * Fetches the available and subscribed categories
     * of the subscribed user.
     *
     * @param userName the customer's username
     * @return CategoryResponse
     */
    @Override
    public CategoryResponse fetchAvailableCategories(String userName) {
        List<AvailableCategoriesResponse> availableCategories = (List<AvailableCategoriesResponse>) availableCategoriesRepository.findAvailableCategoryByName(userName);
        List<SubscribedCategoriesResponse> subscribedCategories = (List<SubscribedCategoriesResponse>) subscribedCategoriesRepository.findSubscribedCategoryByName(userName);
        return new CategoryResponse(availableCategories, subscribedCategories);
    }

    /**
     * Save the subscribed category.
     *
     * @param subscribedCategories customer's subscribed categories
     */
    @Override
    public void saveSubscribedCategory(SubscribedCategories subscribedCategories) {
        subscribedCategoriesRepository.save(subscribedCategories);
    }

    /**
     * Gets the subscribed categories based on customer's name.
     *
     * @param userName customer's username
     * @return list of subscribed categories.
     */
    @Override
    public List<SubscribedCategoriesResponse> getSubscribedCategoryByName(String userName) {
        return (List<SubscribedCategoriesResponse>) subscribedCategoriesRepository.findSubscribedCategoryByName(userName);
    }

    /**
     * Update the subscribed category with the friend's name.
     *
     * @param friendName   name of the friend with whom the subscription is to be shared
     * @param categoryName category of subscription to be shared
     * @param userName     customer's username
     */
    @Override
    public void updateSubscribedCategory(String friendName, String categoryName, String userName) {
        SubscribedCategories subscribedCategories = subscribedCategoriesRepository.findSubscribedCategoryByNameAndUserName(userName, categoryName);
        subscribedCategories.setUserName(friendName);
        subscribedCategories.setName(categoryName);

        subscribedCategoriesRepository.save(subscribedCategories);
    }
}
