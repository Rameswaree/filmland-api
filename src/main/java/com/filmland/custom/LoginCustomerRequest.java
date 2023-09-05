package com.filmland.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginCustomerRequest {

    private String email;
    private String name;
    private String password;
}
