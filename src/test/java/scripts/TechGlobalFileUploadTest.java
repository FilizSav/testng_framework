package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFileUploadPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;

public class TechGlobalFileUploadTest extends TechGlobalBase{
    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalFileUploadPage = new TechGlobalFileUploadPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("File Upload");
    }
    @Test(priority = 1, description = "validate file upload")
    public void fileUploadValidation(){
        String filePath = "/Users/filizsav/IdeaProjects/testng_framework_05/hello.txt";
        techGlobalFileUploadPage.fileUploadInput.sendKeys(filePath);
        Waiter.pause(5);
        techGlobalFileUploadPage.uploadButton.click();
        Assert.assertEquals(techGlobalFileUploadPage.results.getText(),"You Uploaded '" + filePath.substring(filePath.lastIndexOf("/") + 1)+ "'");
    }
}
