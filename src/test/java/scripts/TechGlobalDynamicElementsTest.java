package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDynamicElementsPage;
import pages.TechGlobalFrontendTestingHomePage;

public class TechGlobalDynamicElementsTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalDynamicElementsPage = new TechGlobalDynamicElementsPage();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
    }

    @Test(priority = 1, description = "Testing Dynamic Web Elements")
    public void dynamicElementsTest(){
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(2);

        Assert.assertTrue(techGlobalDynamicElementsPage.box1.isDisplayed());
        Assert.assertEquals(techGlobalDynamicElementsPage.box1.getText(), "Box 1");
    }
    @Test(priority = 2, description = "Testing Dynamic Web Elements")
    public void dynamicElementsTest2(){
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(2);

        Assert.assertTrue(techGlobalDynamicElementsPage.box2.isDisplayed());
        Assert.assertEquals(techGlobalDynamicElementsPage.box2.getText(), "Box 2");

    }
}
