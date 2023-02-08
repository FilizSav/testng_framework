package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalSortedTablePage;
import utilities.TableData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TechGlobalSortedTableTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalSortedTablePage = new TechGlobalSortedTablePage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Sortable Tables");
    }
    @Test(priority = 1, description = "validate sorted table data by asc and quantity")
    public void validateSortedTableData() throws IOException {
        techGlobalSortedTablePage.ascByQuantity.click();
        List<WebElement> quantityColumnElements = TableData.getTableColumn(driver, 1);
        List<Integer> quantityColumn = new ArrayList<>();
        for(WebElement e : quantityColumnElements){
            quantityColumn.add((Integer.parseInt(e.getText())));}
        for (int i = 1; i < quantityColumn.size(); i++) {
            Assert.assertTrue(quantityColumn.get(i) >= quantityColumn.get(i-1));
        }
    }
}
