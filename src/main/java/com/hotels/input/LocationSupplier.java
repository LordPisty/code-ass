package com.hotels.input;

import com.hotels.domain.Location;

import java.util.function.Supplier;


/**
 * Created by screspi on 9/25/15.
 */
@FunctionalInterface
public interface LocationSupplier extends Supplier<Location> {
}
