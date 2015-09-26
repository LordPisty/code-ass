package com.hotels.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Hotel {

    private String name;

    @JsonProperty("location_x")
    private double x;

    @JsonProperty("location_y")
    private double y;

    @JsonProperty("location_z")
    private double z;

    @JsonProperty("rates")
    private List<Rate> rates;

    @JsonProperty("star_rating")
    private int starRating;

    @JsonProperty("user_ratings")
    private List<UserRating> userRatings;

}
