package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("--start-maximized");
                    drivers.set(new ChromeDriver(options));
                    break;
                case firefox:
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options2 = new FirefoxOptions();
                    options2.addArguments("--start-maximized");
                    drivers.set(new FirefoxDriver(options2));
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
