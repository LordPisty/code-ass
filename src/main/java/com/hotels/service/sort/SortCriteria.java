package com.hotels.service.sort;

import static com.hotels.service.sort.SortUtils.computeDistance;
import static com.hotels.service.sort.SortUtils.NAME_COMPARATOR;
import static com.hotels.service.sort.SortUtils.LOWEST_PRICE_COMPARATOR;
import static com.hotels.service.sort.SortUtils.AVERAGE_USER_RATING_COMPARATOR;

import com.hotels.domain.Hotel;
import com.hotels.domain.Location;

import java.util.Comparator;

/**
 * Sorting criteria available: criteria support chaining 2 {@link java.util.Comparator}.
 */
public enum SortCriteria {

    /**
     * Sort according to the distance from location center,
     * and then by name.
     */
    DISTANCE_SORT {
        /**
         * {@inheritDoc}
         */
        @Override
        public Comparator<Hotel> getComparator(Location location) {
            return Comparator.comparing((Hotel hotel) -> computeDistance(location, hotel)).thenComparing(NAME_COMPARATOR);
        }
    },

    /**
     * Sort according to the lowest rate available for that property,
     * and then by name.
     */
    LOWEST_PRICE_SORT (LOWEST_PRICE_COMPARATOR, NAME_COMPARATOR),

    /**
     * Sort according to the average user rating,
     * and then by name.
     */
    AVERAGE_USER_RATING_SORT (AVERAGE_USER_RATING_COMPARATOR, NAME_COMPARATOR);

    private final Comparator<Hotel> comparator;

    SortCriteria() {
        comparator = null;
    }

    SortCriteria(Comparator<Hotel> primaryComparator, Comparator<Hotel> secondaryComparator) {
        comparator = primaryComparator.thenComparing(secondaryComparator);
    }

    /**
     * Returns the comparator associated to this criteria.
     *
     * @param location the location object to eventually use for comparisons
     * @return the comparator associated to this criteria.
     */
    public Comparator<Hotel> getComparator(Location location) {
        return comparator;
    }
}
