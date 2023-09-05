package com.filmland.custom;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is used to share
 * subscription with a friend
 * who is also a registered user.
 */
@Getter
@Setter
public class ShareSubscriptionRequest {

    private String friendName;
    private String categoryName;
}
