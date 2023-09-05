package com.filmland.custom;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is used to allow a customer
 * to make a subscription for a category.
 */
@Getter
@Setter
public class NewSubscriptionRequest {
    private String name;
}
