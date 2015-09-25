package com.hotels.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Hotel {

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    @JsonProperty("location_x")
    private double x;

    @Setter
    @Getter
    @JsonProperty("location_y")
    private double y;

    @Setter
    @Getter
    @JsonProperty("location_z")
    private double z;

    @Setter
    @Getter
    @JsonProperty("rates")
    private List<Rate> rates;

    @Setter
    @Getter
    @JsonProperty("star_rating")
    private int starRating;

    @Setter
    @Getter
    @JsonProperty("user_ratings")
    private List<UserRating> userRatings;

}
