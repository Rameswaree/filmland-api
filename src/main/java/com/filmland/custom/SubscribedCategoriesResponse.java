package com.filmland.custom;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.Date;

/**
 * Response contains the name, remaining content
 * price and subscribed date of the customer's subscribed categories.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubscribedCategoriesResponse {
    private String name;
    private String remainingContent;
    private String price;
    private Date subscribedDate;
}
