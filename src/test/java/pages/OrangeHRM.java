package pages;

import org.openqa.selenium.By;
import utils.Utils;

import java.lang.reflect.Field;
import java.text.MessageFormat;

public class OrangeHRM {

    public static String url = "https://opensource-demo.orangehrmlive.com/";
    public static String username = "Admin";
    public static String password = "admin123";
    public static final String INPUT = "//input[./ancestor::div[contains(@class, \"oxd-input-group\") and .//*[contains(., \"{0}\")]]]";
    public static final String BUTTON = "//button[contains(., \"{0}\")]";
    public static final String LINK = "//a[contains(., \"{0}\")]";

    public static By getLocator(Type typeOrangeHRM, String text) {
        String locator = Utils.getVariableValue(OrangeHRM.class, typeOrangeHRM.name());
        return By.xpath(MessageFormat.format(locator, text));
    }


    public enum Type {
        INPUT,
        BUTTON,
        LINK
        ;

    }

}
