package scripts;

import org.testng.annotations.BeforeMethod;
import pages.TechGlobalCalendarPage;
import pages.TechGlobalFrontendTestingHomePage;

public class TechGlobalCalendarPageTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalCalendarPage = new TechGlobalCalendarPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Calendar");
    }

}
