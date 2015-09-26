package com.hotels.service.sort;

import com.hotels.domain.Hotel;
import com.hotels.domain.Location;

/**
 * Groups utilities for sorting criteria.
 */
public class SortUtils {

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
