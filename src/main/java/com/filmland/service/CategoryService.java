package com.filmland.service;

import com.filmland.custom.CategoryResponse;
import com.filmland.domain.SubscribedCategories;

import java.util.List;

public interface CategoryService {
    CategoryResponse fetchAvailableCategories(String userName);

    void saveSubscribedCategory(SubscribedCategories subscribedCategories);

    List<?> getSubscribedCategoryByName(String userName);

    void updateSubscribedCategory(String friendName, String categoryName, String userName);
}
