package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TechGlobalRadioButtonsPage {
    public TechGlobalRadioButtonsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#radio-button-group_1 label")
    public List<WebElement> radioButtonsLabel;

    @FindBy(css = "#radio-button-group_1 input")
    public List<WebElement> radioButtonsInput;

    @FindBy(css = "#radio-button-group_2 label")
    public List<WebElement> radioButtonsLabel2;

    @FindBy(css = "#radio-button-group_2 input")
    public List<WebElement> radioButtonsInput2;
}
