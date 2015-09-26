package com.hotels.input;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotels.domain.Location;
import org.apache.commons.lang3.Validate;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Implementation of the {@link com.hotels.input.LocationSupplier}
 * interface, that supplies an instance read from a file (xml/json)
 * present on the classpath.
 *
 * <p>There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 */
public class ClasspathFileLocationSupplier implements LocationSupplier {

    /**
     * Default instance returned.
     */
    private Location location = null;


    /**
     * Constructs a classpath based location supplier with the specified
     * file path source.
     *
     * @param filePath the classpath based source file to read from
     */
    public ClasspathFileLocationSupplier(String filePath) {
        Validate.notBlank(filePath);
        final URL url = this.getClass().getResource(filePath);
        if (url != null) {
            final File file = new File(url.getFile());
            final ObjectMapper objMapper = new ObjectMapper();
            try {
                location = objMapper.readValue(file, Location.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns the location instance, or {@code null} if an exception happened.
     */
    @Override
    public Location get() {
        return location;
    }
}
