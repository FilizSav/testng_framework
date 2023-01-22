package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalWaitsPage;
import utilities.Waiter;

public class TechGlobalWaitsTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalWaitsPage = new TechGlobalWaitsPage();

    }
    @Test(priority = 1, description = "Validate red box is visible")
    public void validateRedBox() throws InterruptedException {
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(3);

        techGlobalWaitsPage.redBoxButton.click();
        techGlobalWaitsPage.blueBoxButton.click();
        Waiter.waitForElementToBeClickable(techGlobalWaitsPage.redBoxButton, 60);
        Waiter.waitForElementToBeClickable(techGlobalWaitsPage.blueBoxButton, 60);

        //Assert.assertTrue(techGlobalWaitsPage.redBox.isDisplayed());
       // Assert.assertTrue(techGlobalWaitsPage.blueBox.isDisplayed());

        Waiter.waitForVisibilityOfElements(techGlobalWaitsPage.redBox, 30);
        Waiter.waitForVisibilityOfElements(techGlobalWaitsPage.blueBox, 39);

    }
}
