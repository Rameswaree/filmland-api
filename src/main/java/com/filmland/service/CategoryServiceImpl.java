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
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private AvailableCategoriesRepository availableCategoriesRepository;

    @Autowired
    private SubscribedCategoriesRepository subscribedCategoriesRepository;

    @Override
    public CategoryResponse fetchAvailableCategories(String userName) {
        List<AvailableCategoriesResponse> availableCategories = (List<AvailableCategoriesResponse>) availableCategoriesRepository.findAvailableCategoryByName(userName);
        List<SubscribedCategoriesResponse> subscribedCategories = (List<SubscribedCategoriesResponse>) subscribedCategoriesRepository.findSubscribedCategoryByName(userName);
        return new CategoryResponse(availableCategories, subscribedCategories);
    }

    @Override
    public void saveSubscribedCategory(SubscribedCategories subscribedCategories) {
        subscribedCategoriesRepository.save(subscribedCategories);
    }

    @Override
    public List<SubscribedCategoriesResponse> getSubscribedCategoryByName(String userName) {
        return (List<SubscribedCategoriesResponse>) subscribedCategoriesRepository.findSubscribedCategoryByName(userName);
    }

    @Override
    public void updateSubscribedCategory(String friendName, String categoryName, String userName) {
        SubscribedCategories subscribedCategories = subscribedCategoriesRepository.findSubscribedCategoryByNameAndUserName(userName, categoryName);
        subscribedCategories.setUserName(friendName);
        subscribedCategories.setName(categoryName);

        subscribedCategoriesRepository.save(subscribedCategories);
    }
}
