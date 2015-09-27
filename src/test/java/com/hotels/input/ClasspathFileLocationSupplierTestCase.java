package com.hotels.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.hotels.domain.Location;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by screspi.
 */
public class ClasspathFileLocationSupplierTestCase {

    private LocationSupplier locationSupplier = null;

    private LocationSupplier emptyLocationSupplier = null;

    private LocationSupplier invalidLocationSupplier = null;

    private static final String TEST_FILE_PATH = "/com/hotels/testDataset.json";


    @Before
    public void setup() {
        locationSupplier = new ClasspathFileLocationSupplier(TEST_FILE_PATH);
        invalidLocationSupplier = new ClasspathFileLocationSupplier("random string");
    }

    @Test
    public void testValidGet()  {
        Location location = locationSupplier.get();
        assertEquals("Location name should match", "Galactic center", location.getName());
        assertNotNull("Location hotels should not be null", location.getHotels());
        assertEquals("Hotel name should match", "Bespin Level 1 at Cloud City", location.getHotels().get(0).getName());
        assertNotNull("Hotel rates should not be null", location.getHotels().get(0).getRates());
        assertNotNull("Hotel user ratings should not be null", location.getHotels().get(0).getUserRatings());
        assertEquals("Hotel rate should match", 179, location.getHotels().get(0).getRates().get(0).getBasePrice(), 0.1);
        assertEquals("Hotel user rating should match", 1, location.getHotels().get(0).getUserRatings().get(0).getRating());
    }

    @Test(expected = NullPointerException.class)
    public void testNullPathGet() {
        emptyLocationSupplier = new ClasspathFileLocationSupplier(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyPathGet() {
        emptyLocationSupplier = new ClasspathFileLocationSupplier("");
    }

    @Test
    public void testInvalidGet() {
        Location location = invalidLocationSupplier.get();
        assertNull("Location should be null", location);
    }

}
