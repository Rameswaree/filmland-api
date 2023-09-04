package com.filmland.custom;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryResponse {
    @JsonProperty("availableCategories")
    private List<AvailableCategoriesResponse> availableCategoriesList;
    @JsonProperty("subscribedCategories")
    private List<SubscribedCategoriesResponse> subscribedCategoriesList;
}
