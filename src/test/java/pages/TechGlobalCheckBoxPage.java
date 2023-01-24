package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechGlobalCheckBoxPage extends TechGlobalBasePage{

    @FindBy(css = "#checkbox-button-group_1 label")
    public List<WebElement> checkboxLabel;

    @FindBy(css = "#checkbox-button-group_1 input")
    public List<WebElement> checkboxInput;

    @FindBy(css = "#checkbox-button-group_2 input")
    public List<WebElement> checkBoxLabel2;

    @FindBy(css = "#checkbox-button-group_2 input")
    public List<WebElement> checkBoxInput2;
}
