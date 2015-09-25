package com.hotels.domain;

import lombok.Getter;
import lombok.Setter;

public class Tax {
    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private double rate;

}
