package com.filmland.repository;

import com.filmland.domain.AvailableCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailableCategoriesRepository extends JpaRepository<AvailableCategories, String> {

    List<?> findAvailableCategoryByName(String userName);
}
