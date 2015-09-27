package com.hotels.service.sort;

import static com.hotels.service.sort.SortUtils.computeDistance;
import static com.hotels.service.sort.SortUtils.NAME_COMPARATOR;
import static com.hotels.service.sort.SortUtils.LOWEST_PRICE_COMPARATOR;
import static com.hotels.service.sort.SortUtils.AVERAGE_USER_RATING_COMPARATOR;

import com.hotels.domain.Hotel;
import com.hotels.domain.Location;
import lombok.Getter;

import java.util.Comparator;

/**
 * Sorting criteria available: criteria support chaining 2 {@link java.util.Comparator}.
 */
@Getter
public enum SortCriteria {

    /**
     * Sort according to the distance from location center,
     * and then by name.
     */
    DISTANCE_SORT (null, NAME_COMPARATOR) {
        /**
         * {@inheritDoc}
         */
        @Override
        public Comparator<Hotel> getComparator(Location location) {
            return Comparator.comparing((Hotel hotel) -> computeDistance(location, hotel)).thenComparing(getSecondaryComparator());
        }

        /**
         * Throws an {@link java.lang.IllegalArgumentException}
         *
         * @deprecated Use <code>getComparator(Location location)</code> instead
         */
        @Override
        @Deprecated
        protected Comparator<Hotel> getComparator() {
            throw new IllegalArgumentException("Distance sort criteria requires Location parameter");
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

    private final Comparator<Hotel> primaryComparator;

    private final Comparator<Hotel> secondaryComparator;

    SortCriteria(Comparator<Hotel> primaryComparator, Comparator<Hotel> secondaryComparator) {
        this.primaryComparator = primaryComparator;
        this.secondaryComparator = secondaryComparator;
    }

    /**
     * Returns the comparator associated to this criteria.
     *
     * @param location the location object to use for comparisons
     * @return the comparator associated to this criteria.
     */
    public Comparator<Hotel> getComparator(Location location) {
        return getComparator();
    }

    /**
     * Returns the comparator associated to this criteria.
     *
     * @return the comparator associated to this criteria.
     */
    protected Comparator<Hotel> getComparator() {
        return getPrimaryComparator().thenComparing(getSecondaryComparator());
    }
}
