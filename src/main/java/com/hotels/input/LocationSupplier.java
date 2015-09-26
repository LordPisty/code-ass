package com.hotels.input;

import com.hotels.domain.Location;

import java.util.function.Supplier;


/**
 * Represents a supplier of {@link com.hotels.domain.Location}.
 *
 * <p>There is no requirement that a new or distinct result be returned each
 * time the locationSupplier is invoked.
 */
@FunctionalInterface
public interface LocationSupplier extends Supplier<Location> {
}
