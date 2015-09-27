package com.hotels.service;

import com.hotels.domain.Hotel;
import com.hotels.domain.Location;
import com.hotels.service.sort.SortCriteria;
import com.hotels.service.sort.SortDirection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implementation of the {@link com.hotels.service.HotelSortService}
 * interface, that sort a location hotels according to a criteria
 * and direction.
 *
 * <p>This implementation returns a new list of hotels, without
 * modifying the location object provided.
 */
public class HotelSortServiceImpl implements HotelSortService{

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Hotel> sort(Location location, SortCriteria sortCriteria, SortDirection sortDirection) {
        final List<Hotel> sortedList = null;
        if (location != null && location.getHotels() != null) {
            new ArrayList(location.getHotels());
            final Comparator<Hotel> comparator = sortCriteria.getComparator(location);
            Collections.sort(sortedList, sortDirection.getValue() ? comparator.reversed() : comparator);
        }
        return sortedList;
    }
}
