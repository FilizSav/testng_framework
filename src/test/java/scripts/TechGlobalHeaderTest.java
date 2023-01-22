package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TechGlobalHeaderTest extends TechGlobalBase{
    @Test(priority = 1)
    public void validateTechGlobalHeaderDropdown() {
        Assert.assertTrue(techGlobalBasePage.headerDropdown.isDisplayed());
        Assert.assertEquals(techGlobalBasePage.headerDropdown.getText(), "Practices");
    }

    @Test(priority = 2)
    public void validateTechGlobalHeaderDropdownOptions(){
        techGlobalBasePage.headerDropdown.click();

        String[] optionTexts = {"Frontend Testing", "Backend Testing", "Java Exercises"};

        for (int i = 0; i < techGlobalBasePage.headerDropdownOptions.size(); i++) {
            Assert.assertTrue(techGlobalBasePage.headerDropdownOptions.get(i).isDisplayed());
            Assert.assertTrue(techGlobalBasePage.headerDropdownOptions.get(i).isEnabled());
            Assert.assertEquals(techGlobalBasePage.headerDropdownOptions.get(i).getText(), optionTexts[i]);
        }
    }


}
