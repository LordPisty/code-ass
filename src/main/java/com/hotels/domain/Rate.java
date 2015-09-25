package com.hotels.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Rate {

    @Setter
    @Getter
    @JsonProperty("base_price")
    private double basePrice;

    @Setter
    @Getter
    @JsonProperty("room_id")
    private int roomId;

    @Setter
    @Getter
    private String name;

}
