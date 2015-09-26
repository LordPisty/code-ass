package com.hotels.service.sort;

import static com.hotels.service.sort.SortUtils.computeDistance;

import com.hotels.domain.Hotel;
import com.hotels.domain.Location;

import java.util.Comparator;

/**
 * Sorting criteria available.
 */
public enum SortCriteria {

    /**
     * Sort according to the distance from location center.
     */
    DISTANCE_SORT () {
        /**
         * {@inheritDoc}
         */
        @Override
        public Comparator<Hotel> getComparator(Location location) {
            return (hotel1, hotel2) -> computeDistance(location, hotel1).compareTo(computeDistance(location, hotel2));
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
     * Sort according to the lowest rate available for that property.
     */
    LOWEST_PRICE_SORT () {
        /**
         * {@inheritDoc}
         */
        @Override
        protected Comparator<Hotel> getComparator() {
            return (hotel1, hotel2) -> hotel1.getLowestPrice().compareTo(hotel2.getLowestPrice());
        }
    },

    /**
     * Sort according to the average user rating.
     */
    AVERAGE_USER_RATING_SORT () {
        /**
         * {@inheritDoc}
         */
        @Override
        protected Comparator<Hotel> getComparator() {
            return (hotel1, hotel2) -> hotel1.getAverageUserRating().compareTo(hotel2.getAverageUserRating());
        }
    };

    /**
     * Returns the comparator associated to this criteria.
     *
     * @return the comparator associated to this criteria,
     * or a default comparator based on hotel name.
     */
    public Comparator<Hotel> getComparator(Location location) {
        return getComparator();
    }

    /**
     * Returns the comparator associated to this criteria.
     *
     * @return the comparator associated to this criteria,
     * or a default comparator based on hotel name.
     */
    protected Comparator<Hotel> getComparator() {
        return (hotel1, hotel2) -> hotel1.getName().compareTo(hotel2.getName());
    }
}
