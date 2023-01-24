package scripts;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalAlertsPage;
import pages.TechGlobalFrontendTestingHomePage;

public class TechGlobalAlertsText extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalAlertsPage = new TechGlobalAlertsPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Alerts");
    }
    @Test(priority = 1, description = "Validate warning alert")
    public void warningAlert(){
    techGlobalAlertsPage.clickOnAlert("Warning alert");
    Alert alert = driver.switchTo().alert();
    Assert.assertEquals(alert.getText(),"You are on TechGlobal Training application." );
    alert.accept();
    Assert.assertEquals(techGlobalAlertsPage.results.getText(),"You accepted warning by clicking OK.");
    }
    @Test(priority = 2, description = "Validate confirmation alert")
    public void confirmationAlert(){
        techGlobalAlertsPage.clickOnAlert("Confirmation alert");
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Would you like to stay on TechGlobal Training application?" );
        alert.dismiss();
        Assert.assertEquals(techGlobalAlertsPage.results.getText(),"You rejected the alert by clicking Cancel." );
        techGlobalAlertsPage.clickOnAlert("Confirmation alert");
        alert.accept();
        Assert.assertEquals(techGlobalAlertsPage.results.getText(),"You confirmed the alert by clicking OK.");
    }
}
