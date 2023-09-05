package com.filmland.service;

import com.filmland.custom.LoginCustomerRequest;
import com.filmland.domain.Customer;
import com.filmland.exception.FilmLandException;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmLandService {

    boolean saveUser(LoginCustomerRequest loginCustomerRequest) throws FilmLandException;

    boolean validateUser(LoginCustomerRequest loginCustomerRequest) throws FilmLandException;

    Customer getCustomerByName(String name);

    Customer getDetailsByFriendName(String friendName);
}
