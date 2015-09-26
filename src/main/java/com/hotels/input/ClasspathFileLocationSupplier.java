package com.hotels.input;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotels.domain.Location;
import org.apache.commons.lang3.Validate;

import java.io.File;
import java.io.IOException;

/**
 * Created by screspi on 9/25/15.
 */
public class ClasspathFileLocationSupplier implements LocationSupplier {

    private Location location = null;

    public ClasspathFileLocationSupplier(String filePath) {
        Validate.notBlank(filePath);
        final File file = new File(this.getClass().getResource(filePath).getFile());
        final ObjectMapper objMapper = new ObjectMapper();
        try {
            location = objMapper.readValue(file, Location.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Location get() {
        return location;
    }
}
