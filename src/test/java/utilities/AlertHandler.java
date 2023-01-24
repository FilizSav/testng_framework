package utilities;

public class AlertHandler {
    public static void acceptAlert(){
        Driver.getDriver().switchTo().alert().accept();
    }
    public static void dismissAlert(){
        Driver.getDriver().switchTo().alert().dismiss();
    }
    public static String sendKeysToAlert(String text){
        Driver.getDriver().switchTo().alert().sendKeys(text);
        return text;
    }
    public static String getAlertText(){
        return Driver.getDriver().switchTo().alert().getText();
    }
}
