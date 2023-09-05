package com.filmland.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for {@link SubscribedCategories}
 */
public class SubscribedCategoriesTest {

    private SubscribedCategories subscribedCategories;

    private static final String NAME="Test";
    private static final String USERNAME="Dutch Movies";
    private static final String SUBSCRIBEDCONTENT="20";
    private static final Double PRICE= 6.0;

    @BeforeEach
    public void setUp(){
        subscribedCategories = new SubscribedCategories();
    }

    @Test
    public void shouldReturnNameWhenNameIsSet(){
        subscribedCategories.setName(NAME);

        assertEquals(NAME, subscribedCategories.getName());
    }

    @Test
    public void shouldReturnNullWhenNameIsNotSet(){

        assertNull(subscribedCategories.getName());
    }


    @Test
    public void shouldReturnUserNameWhenUserNameIsSet(){
        subscribedCategories.setUserName(USERNAME);

        assertEquals(USERNAME, subscribedCategories.getUserName());
    }

    @Test
    public void shouldReturnNullWhenUserNameIsNotSet(){

        assertNull(subscribedCategories.getUserName());
    }

    @Test
    public void shouldReturnAvailableContentWhenAvailableContentIsSet(){
        subscribedCategories.setSubscribedContent(SUBSCRIBEDCONTENT);

        assertEquals(SUBSCRIBEDCONTENT, subscribedCategories.getSubscribedContent());
    }

    @Test
    public void shouldReturnNullWhenAvailableContentIsNotSet(){

        assertNull(subscribedCategories.getSubscribedContent());
    }

    @Test
    public void shouldReturnPriceWhenPriceIsSet(){
        subscribedCategories.setPrice(PRICE);

        assertEquals(PRICE, subscribedCategories.getPrice());
    }

    @Test
    public void shouldReturnNullWhenPriceIsNotSet(){

        assertNull(subscribedCategories.getPrice());
    }
}