package com.filmland.repository;

import com.filmland.domain.SubscribedCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscribedCategoriesRepository extends JpaRepository<SubscribedCategories, String> {
    List<?> findSubscribedCategoryByName(String userName);

    SubscribedCategories findSubscribedCategoryByNameAndUserName(String name, String userName);
}
