package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    Properties properties = new Properties();
    String file;

    public static PropertyReader read(String fileName) {
        return new PropertyReader(fileName);
    }

    private PropertyReader(String name) {
        this.file = "src/test/resources/Config/" + name + ".properties";
        try {
            FileReader fileReader = new FileReader(file);
            properties.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}
