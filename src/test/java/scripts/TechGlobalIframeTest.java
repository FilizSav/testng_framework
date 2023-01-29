package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalIframePage;

public class TechGlobalIframeTest extends TechGlobalBase{
    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalIframePage = new TechGlobalIframePage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("IFrames");
    }
    @Test(priority = 1, description = "validating input header text")
    public void validateInputTest(){
        driver.switchTo().frame(techGlobalIframePage.ifFrameId);
        Assert.assertTrue(techGlobalIframePage.inputHeader.isDisplayed());
    }
    @Test(priority = 2, description = "validate submit results")
    public void validateSubmitResults(){
        driver.switchTo().frame(techGlobalIframePage.ifFrameId);
        techGlobalIframePage.firstNameInput.sendKeys("John");
        techGlobalIframePage.lastNameInput.sendKeys("Doe");
        techGlobalIframePage.submit.click();
        driver.switchTo().parentFrame();
        Assert.assertEquals(techGlobalIframePage.results.getText(), "You entered: John Doe");
    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on “Practices” dropdown in the header
     * Select the “Frontend Testing” option
     * Click on the “IFrames” card
     * Enter “John” to first name input box
     * Enter “Doe” to last name input box
     * Click on “SUBMIT” button
     * Validate the result equals “You entered: John Doe”
     */
}
