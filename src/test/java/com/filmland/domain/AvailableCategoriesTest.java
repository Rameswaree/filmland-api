package com.filmland.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for {@link AvailableCategories}
 */
public class AvailableCategoriesTest {

    private AvailableCategories availableCategories;

    private static final String NAME="Test";
    private static final String USERNAME="Dutch Movies";
    private static final String AVAILABLECONTENT="20";
    private static final Double PRICE= 6.0;

    @BeforeEach
    public void setUp(){
        availableCategories = new AvailableCategories();
    }

    @Test
    public void shouldReturnNameWhenNameIsSet(){
        availableCategories.setName(NAME);

        assertEquals(NAME, availableCategories.getName());
    }

    @Test
    public void shouldReturnNullWhenNameIsNotSet(){

        assertNull(availableCategories.getName());
    }


    @Test
    public void shouldReturnUserNameWhenUserNameIsSet(){
        availableCategories.setUserName(USERNAME);

        assertEquals(USERNAME, availableCategories.getUserName());
    }

    @Test
    public void shouldReturnNullWhenUserNameIsNotSet(){

        assertNull(availableCategories.getUserName());
    }

    @Test
    public void shouldReturnAvailableContentWhenAvailableContentIsSet(){
        availableCategories.setAvailableContent(AVAILABLECONTENT);

        assertEquals(AVAILABLECONTENT, availableCategories.getAvailableContent());
    }

    @Test
    public void shouldReturnNullWhenAvailableContentIsNotSet(){

        assertNull(availableCategories.getAvailableContent());
    }

    @Test
    public void shouldReturnPriceWhenPriceIsSet(){
        availableCategories.setPrice(PRICE);

        assertEquals(PRICE, availableCategories.getPrice());
    }

    @Test
    public void shouldReturnNullWhenPriceIsNotSet(){

        assertNull(availableCategories.getPrice());
    }
}