package com.hotels.com.hotels.service.sort;

import com.hotels.domain.Hotel;
import com.hotels.domain.Location;
import com.hotels.domain.Rate;
import com.hotels.domain.UserRating;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.hotels.service.sort.SortCriteria.DISTANCE_SORT;
import static com.hotels.service.sort.SortCriteria.LOWEST_PRICE_SORT;
import static com.hotels.service.sort.SortCriteria.AVERAGE_USER_RATING_SORT;
import static org.junit.Assert.assertEquals;

/**
 * Created by screspi on 9/26/15.
 */
public class SortCriteriaTestCase {

    private Location location;

    private Hotel hotel1;

    private Hotel hotel2;

    @Before
    public void setup() {
        location = new Location();
        location.setX(0);
        location.setY(0);
        location.setZ(0);

        hotel1 = new Hotel();
        hotel1.setX(1);
        hotel1.setY(1);
        hotel1.setZ(1);
        Rate rate1 = new Rate();
        rate1.setBasePrice(77);
        List<Rate> rates1 = new ArrayList<>();
        rates1.add(rate1);
        hotel1.setRates(rates1);
        UserRating userRating1 = new UserRating();
        userRating1.setRating(2);
        UserRating userRating2 = new UserRating();
        userRating2.setRating(4);
        List<UserRating> userRatings1 = new ArrayList<>();
        userRatings1.add(userRating1);
        userRatings1.add(userRating2);
        hotel1.setUserRatings(userRatings1);

        hotel2 = new Hotel();
        hotel2.setX(2);
        hotel2.setY(2);
        hotel2.setZ(2);
        Rate rate3 = new Rate();
        rate3.setBasePrice(90);
        Rate rate4 = new Rate();
        rate4.setBasePrice(58);
        List<Rate> rates2 = new ArrayList<>();
        rates2.add(rate3);
        rates2.add(rate4);
        hotel2.setRates(rates2);
        UserRating userRating3 = new UserRating();
        userRating3.setRating(3);
        List<UserRating> userRatings2 = new ArrayList<>();
        userRatings2.add(userRating3);
        hotel2.setUserRatings(userRatings2);
    }

    @Test
    public void testDistanceSort() {
        int result = DISTANCE_SORT.getComparator(location).compare(hotel1,hotel2);
        assertEquals("Compare to result should match", -1, result);
    }

    @Test
    public void testLowerPriceSort() {
        int result = LOWEST_PRICE_SORT.getComparator(location).compare(hotel1,hotel2);
        assertEquals("Compare to result should match", 1, result);
    }

    @Test
    public void testAverageUserRatingSort() {
        int result = AVERAGE_USER_RATING_SORT.getComparator(location).compare(hotel1,hotel2);
        assertEquals("Compare to result should match", 0, result);
    }
}
