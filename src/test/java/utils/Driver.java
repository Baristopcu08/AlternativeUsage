package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;

import static utils.DriverFactory.createChromeDriver;
import static utils.DriverFactory.createFirefox;

public class Driver {
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    private static ThreadLocal<Browsers> browsers = new ThreadLocal<>();



    public static WebDriver getDriver(){
        return getDriver(browsers.get());
    }

    public static WebDriver getDriver(Browsers browser){
        if(browsers.get()==null){
            browsers.set(browser);}

        if (drivers.get() == null){
            switch (browser){
                case chrome:
                    drivers.set(createChromeDriver("config","chrome.options"));
                    break;
                case firefox:
                    drivers.set(createFirefox("config","frefox.options"));
                    break;
            }
        }
        return drivers.get();
    }


    public static void quitDriver(){
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }
}
