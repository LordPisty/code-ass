package com.hotels;

import com.hotels.domain.Hotel;
import com.hotels.domain.Location;
import com.hotels.input.ClasspathFileLocationSupplier;
import com.hotels.input.LocationSupplier;
import com.hotels.service.HotelSortService;
import com.hotels.service.HotelSortServiceImpl;
import com.hotels.service.sort.SortCriteria;
import com.hotels.service.sort.SortDirection;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static com.hotels.service.sort.SortCriteria.*;
import static com.hotels.service.sort.SortDirection.*;

/**
 * Created by screspi on 9/27/15.
 */
public class IntegrationTest {

    private static final String INT_TEST_FILE_PATH = "/com/hotels/intTestDataset.json";

    private static final String NAME_BESPIN = "Bespin Level 1 at Cloud City";

    private static final String NAME_BETAZED = "Crowne Plaza of Betazed";

    private static final String NAME_CAPRICA = "aloft Caprica City Center";

    private static final String NAME_BABYLON = "Hyatt Place of Babylon 5";

    private static final String NAME_MANASSAS = "DoubleTree of Manassas, Reach";


    private LocationSupplier locationSupplier;

    private HotelSortService service;

    @Before
    public void setup() {
        locationSupplier = new ClasspathFileLocationSupplier(INT_TEST_FILE_PATH);
        service = new HotelSortServiceImpl();
    }

    @Test
    public void testSortPriceAscending() {
        testFullOrder(LOWEST_PRICE_SORT, ASCENDING, new String[]{
                NAME_BESPIN,
                NAME_BETAZED,
                NAME_CAPRICA,
                NAME_MANASSAS,
                NAME_BABYLON,
        });
    }

    @Test
    public void testSortPriceDescending() {
        testFullOrder(LOWEST_PRICE_SORT, DESCENDING, new String[]{
                NAME_BABYLON,
                NAME_MANASSAS,
                NAME_CAPRICA,
                NAME_BETAZED,
                NAME_BESPIN
        });
    }

    @Test
    public void testSortRatingAscending() {
        testFullOrder(AVERAGE_USER_RATING_SORT, ASCENDING, new String[]{
                NAME_BESPIN,
                NAME_BABYLON,
                NAME_MANASSAS,
                NAME_BETAZED,
                NAME_CAPRICA
        });
    }

    @Test
    public void testSortRatingDescending() {
        testFullOrder(AVERAGE_USER_RATING_SORT, DESCENDING, new String[]{
                NAME_CAPRICA,
                NAME_BETAZED,
                NAME_MANASSAS,
                NAME_BABYLON,
                NAME_BESPIN
        });
    }

    @Test
    public void testSortDistanceAscending() {
        testFullOrder(DISTANCE_SORT, ASCENDING, new String[]{
                NAME_BABYLON,
                NAME_BETAZED,
                NAME_CAPRICA,
                NAME_BESPIN,
                NAME_MANASSAS
        });
    }

    @Test
    public void testSortDistanceDescending() {
        testFullOrder(DISTANCE_SORT, DESCENDING, new String[]{
                NAME_MANASSAS,
                NAME_BESPIN,
                NAME_CAPRICA,
                NAME_BETAZED,
                NAME_BABYLON
        });
    }

    private void testFullOrder(SortCriteria sortCriteria, SortDirection sortDirection, String[] hotelNames) {
        final Location location = locationSupplier.get();
        final List<Hotel> hotels = service.sort(location, sortCriteria, sortDirection);
        assertNotNull("Sorted hotels list should not be null", hotels);
        assertEquals("Sorted hotels list size should match", 5, hotels.size());
        assertEquals("First hotel name should match", hotelNames[0], hotels.get(0).getName());
        assertEquals("Second hotel name should match", hotelNames[1], hotels.get(1).getName());
        assertEquals("Third hotel name should match", hotelNames[2], hotels.get(2).getName());
        assertEquals("Fourth hotel name should match", hotelNames[3], hotels.get(3).getName());
        assertEquals("Fifth hotel name should match", hotelNames[4], hotels.get(4).getName());
    }
}
