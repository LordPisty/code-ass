package com.hotels.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

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

    public Double getLowestPrice() {
        Double retVal = Double.MAX_VALUE;
        if (getRates()!= null && !getRates().isEmpty()) {
            retVal = getRates().stream().min((rate1, rate2) -> Double.valueOf(rate1.getBasePrice()).compareTo(Double.valueOf(rate2.getBasePrice()))).get().getBasePrice();
        }
        return retVal;
    }

    public Double getAverageUserRating() {
        Double retVal = 0d;
        if (getUserRatings()!= null && !getUserRatings().isEmpty()) {
            retVal = getUserRatings().stream().collect(Collectors.averagingDouble(UserRating::getRating));
        }
        return retVal;
    }

    public String toString() {
        return getName();
    }

}
