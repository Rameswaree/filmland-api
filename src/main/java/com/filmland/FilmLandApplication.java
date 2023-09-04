package com.filmland;

import com.filmland.domain.AvailableCategories;
import com.filmland.repository.AvailableCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FilmLandApplication implements CommandLineRunner {

    @Autowired
    AvailableCategoriesRepository availableCategoriesRepository;

    public static void main(String[] args) {
        SpringApplication.run(FilmLandApplication.class, args);
    }

    @Override
    public void run(String[] args) {
        AvailableCategories availableCategoriesOne = new AvailableCategories("Rameswaree", "Dutch Films", "10", 4.0);
        AvailableCategories availableCategoriesTwo = new AvailableCategories("Rameswaree", "Dutch Series", "20", 6.0);
        List<AvailableCategories> list = new ArrayList<>();
        list.add(availableCategoriesOne);
        list.add(availableCategoriesTwo);
        availableCategoriesRepository.saveAll(list);
    }
}
