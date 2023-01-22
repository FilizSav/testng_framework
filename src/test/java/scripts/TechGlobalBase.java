package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

public class TechGlobalBase {
    WebDriver driver;
    TechGlobalBasePage techGlobalBasePage;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalDynamicElementsPage techGlobalDynamicElementsPage;
    TechGlobalWaitsPage techGlobalWaitsPage;

    TechGlobalRadioButtonsPage techGlobalRadioButtonsPage;
    TechGlobalCheckBoxPage techGlobalCheckBoxPage;

    @BeforeMethod
    public void setup(){

        driver = Driver.getDriver();
        techGlobalBasePage = new TechGlobalBasePage();
        driver.get(ConfigReader.getProperty("appURL"));
    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
