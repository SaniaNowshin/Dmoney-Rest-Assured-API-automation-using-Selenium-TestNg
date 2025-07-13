package utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.FileNotFoundException;

public class Utils {
    public static void setEnvVar(String key, String value) throws FileNotFoundException, ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration("./src/test/resources/config.properties");
        config.setProperty(key, value);
        config.save();
    }
    public static int generateRandom(int min, int max){
        double randomId = Math.random()*(max-min)+min;
        return (int)randomId;

    }
}
