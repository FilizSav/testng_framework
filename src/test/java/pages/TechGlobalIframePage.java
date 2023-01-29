package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalIframePage extends TechGlobalBasePage{
    public TechGlobalIframePage(){super();}

    @FindBy(css = "#name_form > p")
    public WebElement inputHeader;

    @FindBy(css = "#form_frame")
    public WebElement ifFrameId;

    @FindBy(css = "#first_name")
    public WebElement firstNameInput;

    @FindBy(css = "#last_name")
    public WebElement lastNameInput;

    @FindBy(css = "#result")
    public WebElement results;

    @FindBy(css = "#submit")
    public WebElement submit;



}
