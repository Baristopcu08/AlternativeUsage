package tests;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.OpenCart;
import pages.OrangeHRM;
import utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class Tests extends BaseTest {

    Map<String, String> windows = new HashMap<>();

    @Test
    public void test_openCart(){
        open(OpenCart.url);
        click(OpenCart.getLocator(OpenCart.Type.TOP_MENU,"My Account"));
        click(OpenCart.getLocator(OpenCart.Type.TOP_MENU,"Login"));
        sendkey(OpenCart.getLocator(OpenCart.Type.INPUT, "E-Mail Address"), OpenCart.username);
        sendkey(OpenCart.getLocator(OpenCart.Type.INPUT, "Password"), OpenCart.password);
        click(OpenCart.getLocator(OpenCart.Type.BUTTON, "Login"));
    }

    @Test
    public void test_orangeHRM(){
        open(OrangeHRM.url);
        sendkey(OrangeHRM.getLocator(OrangeHRM.Type.INPUT, "Username"), OrangeHRM.username);
        sendkey(OrangeHRM.getLocator(OrangeHRM.Type.INPUT, "Password"), OrangeHRM.password);
        click(OrangeHRM.getLocator(OrangeHRM.Type.BUTTON, "Login"));
    }


    @Test
    public void test3(){
        open(OpenCart.url);
        click(OpenCart.getLocator(OpenCart.Type.TOP_MENU,"My Account"));
        click(OpenCart.getLocator(OpenCart.Type.TOP_MENU,"Login"));
        sendkey(OpenCart.getLocator(OpenCart.Type.INPUT, "E-Mail Address"), OpenCart.username);
        sendkey(OpenCart.getLocator(OpenCart.Type.INPUT, "Password"), OpenCart.password);
        click(OpenCart.getLocator(OpenCart.Type.BUTTON, "Login"));
        waitForPresence(OpenCart.getLocator(OpenCart.Type.LINK, "Logout"));
        windows.put("opencart", getWindowHandler());

        driver.switchTo().newWindow(WindowType.TAB).get(OrangeHRM.url);
        open(OrangeHRM.url);
        windows.put("orangehrm", getWindowHandler());
        sendkey(OrangeHRM.getLocator(OrangeHRM.Type.INPUT, "Username"), OrangeHRM.username);
        sendkey(OrangeHRM.getLocator(OrangeHRM.Type.INPUT, "Password"), OrangeHRM.password);
        click(OrangeHRM.getLocator(OrangeHRM.Type.BUTTON, "Login"));
        waitForPresence(OrangeHRM.getLocator(OrangeHRM.Type.LINK, "Admin"));
        System.out.println(windows);

        for (int i = 0; i < 10; i++) {
            driver.switchTo().window(windows.get("opencart"));
            waitForPresence(OpenCart.getLocator(OpenCart.Type.LINK, "Logout"));
            Utils.sleep(500);
            driver.switchTo().window(windows.get("orangehrm"));
            waitForPresence(OrangeHRM.getLocator(OrangeHRM.Type.LINK, "Admin"));
            Utils.sleep(500);
        }
    }

    @Test
    public void xx(){
        driver.get(OpenCart.url);
        System.out.println(driver.getWindowHandle());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(OrangeHRM.url);
        System.out.println(driver.getWindowHandle());

    }







}
