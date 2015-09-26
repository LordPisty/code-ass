package com.hotels.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRating {

    @JsonProperty("user_id")
    private String user_id;

    private int rating;

}
