package com.hotels.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Location {

    @JsonProperty("location_id")
    private int id;

    private String name;

    @JsonProperty("location_x")
    private double x;

    @JsonProperty("location_y")
    private double y;

    @JsonProperty("location_z")
    private double z;

    private List<Tax> taxes;

    private List<Hotel> hotels;
}
