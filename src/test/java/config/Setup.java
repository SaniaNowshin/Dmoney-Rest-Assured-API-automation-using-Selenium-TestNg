package config;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Setup {
    public Properties prop;
    public FileInputStream fs;
    @BeforeTest
    public void setup() throws IOException {
            prop = new Properties();
            fs = new FileInputStream("./src/test/resources/config.properties");
            prop.load(fs);
        }
    @AfterTest
    public void refreshSetup() throws IOException {
        prop = new Properties();
        fs = new FileInputStream("./src/test/resources/config.properties");
        prop.load(fs);
    }
}


