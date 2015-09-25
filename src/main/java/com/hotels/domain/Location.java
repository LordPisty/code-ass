package com.hotels.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Location {

    @Setter
    @Getter
    @JsonProperty("location_id")
    private int id;

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
    private List<Tax> taxes;

    @Setter
    @Getter
    private List<Hotel> hotels;
}
