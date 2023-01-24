package utilities;

import org.openqa.selenium.WebDriver;

public class AlertHandler {
    public static void acceptAlert(WebDriver driver){
        driver.switchTo().alert().accept();
    }
    public static void dismissAlert(WebDriver driver){
        driver.switchTo().alert().dismiss();
    }
    public static void sendKeysToAlert(WebDriver driver, String text){
        driver.switchTo().alert().sendKeys(text);
    }
    public static void getAlertText(WebDriver driver){
        driver.switchTo().alert().getText();
    }
}
