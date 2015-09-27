package com.hotels.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by screspi.
 */
public class HotelTestCase {

    private Hotel hotel;
    
    @Before
    public void setup() {
        hotel = new Hotel();
        Rate rate1 = new Rate();
        rate1.setBasePrice(77.345);
        Rate rate2 = new Rate();
        rate2.setBasePrice(90);
        List<Rate> rates1 = new ArrayList<>();
        rates1.add(rate1);
        rates1.add(rate2);
        hotel.setRates(rates1);
        UserRating userRating1 = new UserRating();
        userRating1.setRating(2);
        UserRating userRating2 = new UserRating();
        userRating2.setRating(4);
        List<UserRating> userRatings1 = new ArrayList<>();
        userRatings1.add(userRating1);
        userRatings1.add(userRating2);
        hotel.setUserRatings(userRatings1);
    }

    @Test
    public void testGetLowestPrice() {
        double result = hotel.getLowestPrice();
        assertEquals("Lowest price should match", 77.345, result, 0.0001);
    }

    @Test
    public void testGetAverageUserRating() {
        double result = hotel.getAverageUserRating();
        assertEquals("Average user rating should match", 3, result, 0.0001);
    }
}
