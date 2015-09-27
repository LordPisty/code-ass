package com.hotels.service;

import com.hotels.domain.Hotel;
import com.hotels.domain.Location;
import com.hotels.service.sort.SortCriteria;
import com.hotels.service.sort.SortDirection;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by screspi.
 */
public class HotelSortServiceImplTestCase {

    private Location location;

    private SortCriteria criteria;

    private HotelSortService service;

    @Before
    public void setup() {
        location = new Location();
        List<Hotel> hotels = new ArrayList<>();
        Hotel hotelA = new Hotel();
        hotelA.setName("A");
        Hotel hotelB = new Hotel();
        hotelB.setName("B");
        hotels.add(hotelA);
        hotels.add(hotelB);
        location.setHotels(hotels);

        criteria = mock(SortCriteria.class);
        when(criteria.getComparator(isA(Location.class))).thenReturn((hotel1, hotel2) -> hotel1.getName().compareTo(hotel2.getName()));

        service = new HotelSortServiceImpl();
    }

    @Test
    public void testSortAscending() {
        List<Hotel> hotels = service.sort(location, criteria, SortDirection.ASCENDING);
        assertNotNull("Sorted hotels list should not be null", hotels);
        assertEquals("Sorted hotels list size should match", 2, hotels.size());
        assertEquals("First hotel name should match", "A", hotels.get(0).getName());
        assertEquals("Second hotel name should match", "B", hotels.get(1).getName());
    }

    @Test
    public void testSortDescending() {
        List<Hotel> hotels = service.sort(location, criteria, SortDirection.DESCENDING);
        assertNotNull("Sorted hotels list should not be null", hotels);
        assertEquals("Sorted hotels list size should match", 2, hotels.size());
        assertEquals("First hotel name should match", "B", hotels.get(0).getName());
        assertEquals("Second hotel name should match", "A", hotels.get(1).getName());
    }
}
