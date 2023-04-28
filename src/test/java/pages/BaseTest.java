package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;


    public BaseTest(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public String getWindowHandler(){
        return driver.getWindowHandle();
    }

    public void waitForVisibility(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForPresence(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void sendkey(By locator, CharSequence...text){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
    }

    public void click(By locator){
        click(locator, 0);
    }

    public WebElement getElement(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> getElements(By locator){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void click(By locator, int index){
        index = Math.max(0, index);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
        List<WebElement> list = driver.findElements(locator);
        list.get(index).click();
    }

    public void open(String url){
        driver.get(url);
    }

    @AfterTest
    public void afterTest(){
        Driver.quitDriver();
    }


}
