package com.hotels;

import com.hotels.domain.Hotel;
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

/**
 * Created by screspi on 9/25/15.
 */
public class Main {

    private static final String PROPERTIES_FILE = "/config.properties";

    private static final String DATASET_PATH = "dataset.path";

    public static void main(String[] args) {

        Properties prop = new Properties();
        try (InputStream input = Main.class.getResourceAsStream(PROPERTIES_FILE)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        final LocationSupplier locationSupplier = new ClasspathFileLocationSupplier(prop.getProperty(DATASET_PATH));
        final Location location = locationSupplier.get();
        System.out.println(location);

        final HotelSortService sortService = new HotelSortServiceImpl();

        System.out.println("distance");
        sortService.sort(location, SortCriteria.DISTANCE_SORT, SortDirection.DESCENDING).stream().forEach(System.out::println);
        sortService.sort(location, SortCriteria.DISTANCE_SORT, SortDirection.ASCENDING).stream().forEach(System.out::println);

        System.out.println("price");
        sortService.sort(location, SortCriteria.LOWEST_PRICE_SORT, SortDirection.DESCENDING).stream().forEach(System.out::println);
        sortService.sort(location, SortCriteria.LOWEST_PRICE_SORT, SortDirection.ASCENDING).stream().forEach(System.out::println);

        System.out.println("rating");
        sortService.sort(location, SortCriteria.AVERAGE_USER_RATING_SORT, SortDirection.DESCENDING).stream().forEach(System.out::println);
        sortService.sort(location, SortCriteria.AVERAGE_USER_RATING_SORT, SortDirection.ASCENDING).stream().forEach(System.out::println);

    }
}
