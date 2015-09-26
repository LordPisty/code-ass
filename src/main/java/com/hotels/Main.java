package com.hotels;

import com.hotels.input.ClasspathFileLocationSupplier;
import com.hotels.input.LocationSupplier;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by screspi on 9/25/15.
 */
public class Main {

    private static final String PROPERTIES_FILE = "/config.properties";

    private static final String DATASET_PATH = "dataset.path";

    public static void main(String[] args) {

        Properties prop = new Properties();
        try (InputStream input = Main.class.getResourceAsStream(PROPERTIES_FILE)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        final LocationSupplier locationSupplier = new ClasspathFileLocationSupplier(prop.getProperty(DATASET_PATH));
        System.out.println(locationSupplier.get());

    }
}
