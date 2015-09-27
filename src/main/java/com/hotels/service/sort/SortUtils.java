package com.hotels.service.sort;

import com.hotels.domain.Hotel;
import com.hotels.domain.Location;

import java.util.Comparator;

/**
 * Groups utilities for sorting criteria.
 */
public class SortUtils {

    /**
     * Compare hotels based on name.
     */
    public static final Comparator<Hotel> NAME_COMPARATOR = Comparator.comparing(Hotel::getName);

    /**
     * Compare hotels based on lowest room price.
     */
    public static final Comparator<Hotel> LOWEST_PRICE_COMPARATOR = Comparator.comparing(Hotel::getLowestPrice);

    /**
     * Compare hotels based on average user rating.
     */
    public static final Comparator<Hotel> AVERAGE_USER_RATING_COMPARATOR = Comparator.comparing(Hotel::getAverageUserRating);

    /**
     * Returns the euclidean distance between a location and a hotel,
     * calculated by Pythagorean theorem.
     *
     * @param location the location object to operate sorting on
     * @param hotel the criteria to use when sorting
     *
     * @return the euclidean distance between the specified location and hotel
     */
    public static final Double computeDistance(Location location, Hotel hotel) {
        double xDiff = Math.abs (location.getX() - hotel.getX());
        double yDiff = Math.abs (location.getY() - hotel.getY());
        double zDiff = Math.abs (location.getZ() - hotel.getZ());
        return Math.sqrt((xDiff*xDiff) + (yDiff*yDiff) + (zDiff*zDiff));
    }
}
