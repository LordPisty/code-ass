package com.hotels;

import com.hotels.domain.Location;
import com.hotels.input.FileLocationSupplier;
import com.hotels.input.LocationSupplier;

/**
 * Created by screspi on 9/25/15.
 */
public class Main {

    public static void main(String[] args) {

        final LocationSupplier locationSupplier = new FileLocationSupplier();
        System.out.println(locationSupplier.get());

    }
}
