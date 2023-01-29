package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

public class TechGlobalBase {
    WebDriver driver;
    SoftAssert softAssert;
    TechGlobalBasePage techGlobalBasePage;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalDynamicElementsPage techGlobalDynamicElementsPage;
    TechGlobalWaitsPage techGlobalWaitsPage;

    TechGlobalRadioButtonsPage techGlobalRadioButtonsPage;
    TechGlobalCheckBoxPage techGlobalCheckBoxPage;

    TechGlobalDropdownsPage techGlobalDropdownsPage;
    TechGlobalMultipleWindowsPage techGlobalMultipleWindowsPage;
    TechGlobalAlertsPage techGlobalAlertsPage;
    TechGlobalDynamicTablesPage techGlobalDynamicTablesPage;
    TechGlobalIframePage techGlobalIframePage;
    TechGlobalFileUploadPage techGlobalFileUploadPage;

    TechGlobalFileDownloadPage techGlobalFileDownloadPage;

    TechGlobalFileStaticTablesPage techGlobalFileStaticTablesPage;
    TechGlobalCalendarPage techGlobalCalendarPage;

    @BeforeMethod
    public void setup(){

        driver = Driver.getDriver();
        softAssert = new SoftAssert();
        techGlobalBasePage = new TechGlobalBasePage();
        driver.get(ConfigReader.getProperty("appURL"));
    }
    @AfterTest
    public void teardown(){
        softAssert.assertAll(); driver.quit();
    }
}
