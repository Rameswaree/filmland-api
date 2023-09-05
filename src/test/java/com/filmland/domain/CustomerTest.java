package com.filmland.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Unit test for {@link Customer}
 */
public class CustomerTest {
    private Customer customer;

    private static final int ID=1;
    private static final String NAME="Test";
    private static final String EMAIL="test@gmail.com";
    private static final String PASSWORD="test1234";

    @BeforeEach
    public void setUp(){
        customer = new Customer();
    }

    @Test
    public void shouldReturnIdWhenIdIsSet(){
        customer.setId(ID);

        assertEquals(ID, customer.getId());
    }

    @Test
    public void shouldReturnZeroWhenIdIsNotSet(){

        assertEquals(0, customer.getId());
    }


    @Test
    public void shouldReturnEmailWhenEmailIsSet(){
        customer.setEmail(EMAIL);

        assertEquals(EMAIL, customer.getEmail());
    }

    @Test
    public void shouldReturnNullWhenNameIsNotSet(){

        assertNull(customer.getName());
    }

    @Test
    public void shouldReturnNameWhenNameIsSet(){
        customer.setName(NAME);

        assertEquals(NAME, customer.getName());
    }

    @Test
    public void shouldReturnNullWhenEmailIsNotSet(){

        assertNull(customer.getEmail());
    }

    @Test
    public void shouldReturnPasswordWhenPasswordIsSet(){
        customer.setPassword(PASSWORD);

        assertEquals(PASSWORD, customer.getPassword());
    }

    @Test
    public void shouldReturnNullWhenPasswordIsNotSet(){

        assertNull(customer.getPassword());
    }
}