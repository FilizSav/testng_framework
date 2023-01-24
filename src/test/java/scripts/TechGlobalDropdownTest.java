package scripts;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDropdownsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.DropdownHandler;
import utilities.Waiter;

public class TechGlobalDropdownTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDropdownsPage = new TechGlobalDropdownsPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Dropdowns");
    }
    @Test(priority = 1, description = "Select Delivery Option")

    public void selectDeliveryOption(){
        DropdownHandler.clickOnDropdownOption(techGlobalDropdownsPage.deliveryDropdown,
                techGlobalDropdownsPage.deliveryDropdownOptions,"Delivery");
    }
    @Test(priority = 2, description = "Select iPhone 14 ProMax Option")

    public void selectProductOption(){
        DropdownHandler.selectByVisibleText(techGlobalDropdownsPage.productDropdown, "iPhone 14 Pro Max");
        Waiter.pause(2);
    }
    @Test(priority = 3, description = "Select Yellow Color Option")

    public void selectColorOption(){
        Select select = new Select(techGlobalDropdownsPage.colorDropdown);
        select.selectByIndex(1);
        Waiter.pause(2);
    }
    @Test(priority = 4, description = "Validate the selected item message")
    public void validateTheItemSelected(){
        DropdownHandler.selectByIndex(techGlobalDropdownsPage.productDropdown, 3);
        DropdownHandler.selectByVisibleText(techGlobalDropdownsPage.colorDropdown, "Silver");
        DropdownHandler.clickOnDropdownOption(techGlobalDropdownsPage.deliveryDropdown,
                techGlobalDropdownsPage.deliveryDropdownOptions, "Delivery");

        techGlobalDropdownsPage.submitButton.click();
        Assert.assertEquals(techGlobalDropdownsPage.resultMessage.getText(), "Your Silver MacBook Pro 13 will be delivered to you.");
        Waiter.pause(5);
    }

}
