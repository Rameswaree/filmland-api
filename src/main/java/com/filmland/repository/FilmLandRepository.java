package com.filmland.repository;

import com.filmland.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmLandRepository extends JpaRepository<Customer, Integer> {

    Customer findByName(String name);
}
