package com.hotels.input;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotels.domain.Location;

import java.io.File;
import java.io.IOException;

/**
 * Created by screspi on 9/25/15.
 */
public class FileLocationSupplier implements LocationSupplier {

    @Override
    public Location get() {
        final File file = new File(this.getClass().getResource("/com/hotels/dataset.json").getFile());
        final ObjectMapper objMapper = new ObjectMapper();
        Location location = null;
        try {
            location = objMapper.readValue(file, Location.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return location;
    }
}
