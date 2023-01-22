package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class TechGlobalLogoTest extends TechGlobalBase{


    @Test
    public void validateTechGlobalLogo(){
        Waiter.waitForVisibilityOfElements(techGlobalBasePage.logo, 60);
        Assert.assertTrue(techGlobalBasePage.logo.isDisplayed());
    }

}
