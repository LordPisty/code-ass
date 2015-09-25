package com.hotels.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class UserRating
{
    @Setter
    @Getter
    @JsonProperty("user_id")
    private String user_id;

    @Setter
    @Getter
    private int rating;
	
}
