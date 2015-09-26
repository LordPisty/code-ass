package com.hotels.service;

import com.hotels.domain.Hotel;
import com.hotels.domain.Location;
import com.hotels.service.sort.SortCriteria;
import com.hotels.service.sort.SortDirection;

import java.util.List;

/**
 * Represents a service to sort hotels from a {@link com.hotels.domain.Location} object.
 *
 * <p>Sorting can be done according to criteria available in
 * {@link com.hotels.service.sort.SortCriteria} and direction
 * available in {@link com.hotels.service.sort.SortDirection}.
 */
public interface HotelSortService {

    /**
     * Returns a sorted list of the hotels related to the specified location,
     * according to the specified criteria and direction.
     *
     * @param location the location object to operate sorting on
     * @param sortCriteria the criteria to use when sorting
     * @param sortDirection the direction to use when sorting
     */
    List<Hotel> sort(Location location, SortCriteria sortCriteria, SortDirection sortDirection);

}
