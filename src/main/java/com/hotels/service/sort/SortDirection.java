package com.hotels.service.sort;

/**
 * Sorting directions.
*/
public enum SortDirection {

    /**
     * Descending sorting direction.
     */
    DESCENDING (true),

    /**
     * Ascending sorting direction.
     */
    ASCENDING (false);

    private final boolean value;

    /**
     * Constructs a sort direction with the specified value.
     *
     * @param value the boolean value
     */
    private SortDirection(boolean value) {
        this.value = value;
    }


    /**
     * Returns the boolean representation of this enumerated type constants.
     *
     * @return {@code true} for descending, {@code false} for ascending
     */
    public boolean getValue() {
        return this.value;
    }
}
