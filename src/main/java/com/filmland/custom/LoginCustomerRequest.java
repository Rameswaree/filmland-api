package com.filmland.custom;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCustomerRequest {

    private String email;
    private String name;
    private String password;
}
