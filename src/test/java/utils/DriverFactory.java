package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Arrays;

public class DriverFactory {

    public static WebDriver createChromeDriver( String fileName, String propertiesFileKey){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        String config = PropertyReader.read(fileName).get(propertiesFileKey);
        Arrays.stream(config.split(",")).map(String::trim).forEach(options::addArguments);
       return new ChromeDriver(options);

    }

    public static WebDriver createFirefox( String fileName, String propertiesFileKey){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options=new FirefoxOptions();
        String config = PropertyReader.read(fileName).get(propertiesFileKey);
        Arrays.stream(config.split(",")).map(String::trim).forEach(options::addArguments);
        return new FirefoxDriver(options);

    }
}
