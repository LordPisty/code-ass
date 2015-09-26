package com.hotels.com.hotels.service.sort;

import com.hotels.domain.Hotel;
import com.hotels.domain.Location;
import com.hotels.service.sort.SortUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by screspi on 9/26/15.
 */
public class SortUtilsTestCase {

    private Location location;

    private Hotel hotel;

    @Before
    public void setup() {
        location = new Location();
        location.setX(1.2);
        location.setY(-7);
        location.setZ(5.34);

        hotel = new Hotel();
        hotel.setX(34);
        hotel.setY(-10.5);
        hotel.setZ(-77);
    }

    @Test
    public void testComputeDistance()  {
        Double distance = SortUtils.computeDistance(location, hotel);
        assertEquals("Computed distance should match", 88.701, distance.doubleValue(), 0.001);
    }
}
