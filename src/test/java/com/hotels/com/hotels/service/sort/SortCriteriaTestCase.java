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
import static org.junit.Assert.assertTrue;

/**
 * Created by screspi.
 */
public class SortCriteriaTestCase {

    private Location location;

    private Hotel hotel1;

    private Hotel hotel1Name;

    private Hotel hotel2;

    @Before
    public void setup() {
        location = new Location();
        location.setX(0);
        location.setY(0);
        location.setZ(0);

        hotel1 = new Hotel();
        hotel1.setName("A");
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

        hotel1Name = new Hotel();
        hotel1Name.setName("a");
        hotel1Name.setX(1);
        hotel1Name.setY(1);
        hotel1Name.setZ(1);
        hotel1Name.setRates(rates1);
        hotel1Name.setUserRatings(userRatings1);

        hotel2 = new Hotel();
        hotel2.setName("B");
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

    private void assertLessThanZero(int result) {
        assertTrue("Compare result should be < 0", result < 0);
    }

    private void assertGreaterThanZero(int result) {
        assertTrue("Compare result should be > 0", result > 0);
    }

    private void assertEqualsZero(int result) {
        assertEquals("Compare result should match", 0, result);
    }

    @Test
    public void testDistanceSortPrimary() {
        int result = DISTANCE_SORT.getComparator(location).compare(hotel1,hotel2);
        assertLessThanZero(result);
    }

    @Test
    public void testDistanceSortSecondary() {
        int result = DISTANCE_SORT.getComparator(location).compare(hotel1,hotel1);
        assertEqualsZero(result);
    }

    @Test
    public void testDistanceSortSecondaryName() {
        int result = DISTANCE_SORT.getComparator(location).compare(hotel1,hotel1Name);
        assertLessThanZero(result);
    }

    @Test
    public void testLowerPriceSortPrimary() {
        int result = LOWEST_PRICE_SORT.getComparator(location).compare(hotel1,hotel2);
        assertGreaterThanZero(result);
    }

    @Test
    public void testLowerPriceSortSecondary() {
        int result = LOWEST_PRICE_SORT.getComparator(location).compare(hotel1,hotel1);
        assertEqualsZero(result);
    }

    @Test
    public void testLowerPriceSortSecondaryName() {
        int result = LOWEST_PRICE_SORT.getComparator(location).compare(hotel1,hotel1Name);
        assertLessThanZero(result);
    }

    @Test
    public void testAverageUserRatingSortPrimary() {
        int result = AVERAGE_USER_RATING_SORT.getComparator(location).compare(hotel1,hotel2);
        assertLessThanZero(result);
    }

    @Test
    public void testAverageUserRatingSortSecondary() {
        int result = AVERAGE_USER_RATING_SORT.getComparator(location).compare(hotel1,hotel1);
        assertEqualsZero(result);
    }

    @Test
    public void testAverageUserRatingSortSecondaryName() {
        int result = AVERAGE_USER_RATING_SORT.getComparator(location).compare(hotel1,hotel1Name);
        assertLessThanZero(result);
    }
}
