package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;


    public static Properties initialize_Properties() {
        properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Config file not found", e);
        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading config file", e);
        }

        return getProperties();
    }

    public static Properties getProperties() {
        return properties;
    }


}
