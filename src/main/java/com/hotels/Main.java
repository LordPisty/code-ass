package com.hotels;

import com.hotels.domain.Location;
import com.hotels.input.ClasspathFileLocationSupplier;
import com.hotels.input.LocationSupplier;
import com.hotels.service.HotelSortService;
import com.hotels.service.HotelSortServiceImpl;
import com.hotels.service.sort.SortCriteria;
import com.hotels.service.sort.SortDirection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by screspi.
 */
public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    private static final String PROPERTIES_FILE = "/config.properties";

    private static final String DATASET_PATH = "dataset.path";

    private static void exitWithMessage(final String message) {
        LOGGER.severe(message);
        LOGGER.severe("Sorting criteria available options: distance, rate, price");
        LOGGER.severe("Sorting direction available options: ascending, descending");
        System.exit(0);
    }

    public static void main(String[] args) {

        if (args.length < 2) {
            exitWithMessage("Missing arguments: please specify sorting criteria and sorting direction");
        }

        SortCriteria sortCriteria = null;
        switch (args[0]) {
            case "distance": {
                sortCriteria = SortCriteria.DISTANCE_SORT;
                break;
            }
            case "price": {
                sortCriteria = SortCriteria.LOWEST_PRICE_SORT;
                break;
            }
            case "rating": {
                sortCriteria = SortCriteria.AVERAGE_USER_RATING_SORT;
                break;
            }
        }
        if (sortCriteria == null) {
            exitWithMessage("Invalid sorting criteria argument: " + args[0]);
        }

        SortDirection sortDirection = null;
        switch (args[1]) {
            case "ascending": {
                sortDirection = SortDirection.ASCENDING;
                break;
            }
            case "descending": {
                sortDirection = SortDirection.DESCENDING;
                break;
            }
        }
        if (sortDirection == null) {
            exitWithMessage("Invalid sorting direction argument: " + args[1]);
        }

        Properties prop = new Properties();
        try (InputStream input = Main.class.getResourceAsStream(PROPERTIES_FILE)) {
            prop.load(input);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE,"Error reading properties file at: "+PROPERTIES_FILE, e);
        }

        final LocationSupplier locationSupplier = new ClasspathFileLocationSupplier(prop.getProperty(DATASET_PATH));
        final Location location = locationSupplier.get();

        final HotelSortService sortService = new HotelSortServiceImpl();

        LOGGER.info("Hotels sorted according to criteria: " + args[0] + ", direction: " + args[1]);
        sortService.sort(location, sortCriteria, sortDirection).stream().forEach(hotel -> LOGGER.info(hotel.toString()));
    }
}
