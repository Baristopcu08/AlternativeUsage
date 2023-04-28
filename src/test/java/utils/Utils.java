package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.time.Duration;

public class Utils {


    public static String getVariableValue(Class<?> clazz, String fieldName){

        String result = null;
        try {
            Field field = clazz.getDeclaredField(fieldName);
            result = (String) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result ;

    }

    public static void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
