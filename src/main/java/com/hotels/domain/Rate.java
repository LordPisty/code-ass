package com.hotels.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Rate {

    @JsonProperty("base_price")
    private double basePrice;

    @JsonProperty("room_id")
    private int roomId;

    private String name;

}
