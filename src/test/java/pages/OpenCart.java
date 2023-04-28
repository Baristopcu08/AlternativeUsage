package pages;

import org.openqa.selenium.By;
import utils.Utils;

import java.lang.reflect.Field;
import java.text.MessageFormat;

public class OpenCart {

    public static String url = "http://opencart.abstracta.us/";
    public static String username = "deneme@deneme.com";
    public static String password = "deneme";
    public static final String INPUT = "//input[.//parent::div[.//*[contains(., \"{0}\")]]]";
    public static final String LINK = "//a[contains(., \"{0}\")]";
    public static final String BUTTON = "//input[@*[contains(., \"{0}\")] or contains(., \"{0}\")]";
    public static final String CART_BUTTON = "//div[@id=\"content\"]//tr[contains(., \"{0}\")]//button[@data-original-title=\"{0}\"]";
    public static final String CART_DELETE_BUTTONS = "//div[@id=\"content\"]//form//button[2]";
    public static final String CART_UPDATE_INPUT = "//input[.//ancestor::tr[.//.=\"{0}\"]]";
    public static final String CART_UPDATE_BUTTONS = "//button[.//ancestor::tr[.//.=\"{0}\"] and @data-original-title=\"Update\"]";
    public static final String TOP_MENU = "//div[@id=\"top-links\"]//a[contains(., \"{0}\")]";


    public static By getLocator(Type typeOpenCart, String text) {
        String locator = Utils.getVariableValue(OpenCart.class, typeOpenCart.name());
        return By.xpath(MessageFormat.format(locator, text));
    }


    public enum Type {
        INPUT,
        LINK,
        BUTTON,
        CART_BUTTON,
        CART_DELETE_BUTTONS,
        CART_UPDATE_INPUT,
        CART_UPDATE_BUTTONS,
        TOP_MENU;
    }
}
