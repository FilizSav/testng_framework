package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalCalendarPage;
import pages.TechGlobalFrontendTestingHomePage;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class TechGlobalCalendarPageTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalCalendarPage = new TechGlobalCalendarPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Calendar");
    }


    @Test(priority = 1, description = "Validate date picker")
    public void ValidateDatePicker(){

        techGlobalCalendarPage.calendarButton.click();

        int year = 2024, month = 5, day = 16;

        String monthSting = Month.of(month).toString().charAt(0) + Month.of(month).toString().substring(1).toLowerCase();


        techGlobalCalendarPage.navigateToYearAndMonth(year, monthSting);

        techGlobalCalendarPage.clickOnDate(day);

        LocalDate selectedDate = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy");
        String expectedDate = selectedDate.format(formatter);

        Assert.assertEquals(techGlobalCalendarPage.result.getText(), "You have selected " + expectedDate + ".");
    }
}
