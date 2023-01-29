package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFileStaticTablesPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.TableData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class TechGlobalStaticTablesTest extends TechGlobalBase {
    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalFileStaticTablesPage = new TechGlobalFileStaticTablesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Static Tables");
    }

    @Test(priority = 1, description = "")
    public void validateStaticTableInfo() {
        String[] headers = {"Rank", "Company", "Employees", "Country"};
        for (int i = 0; i < techGlobalFileStaticTablesPage.tableHeaders.size(); i++) {
            Assert.assertEquals(techGlobalFileStaticTablesPage.tableHeaders.get(i).getText(), headers[i]);
            System.out.println(techGlobalFileStaticTablesPage.tableHeaders.get(i).getText());
        }
        int i = 0;
        for (WebElement e : techGlobalFileStaticTablesPage.tableHeaders)
            Assert.assertEquals(e.getText(), headers[i++]);
    }

    @Test(priority = 1, description = "validate column")
    public void validateColumnInfo() {
        String[] headers = {"Amazon", "Alibaba", "Microsoft", "Apple", "Samsung"};
        for (int i = 0; i < techGlobalFileStaticTablesPage.rowInfo.size(); i++) {
            Assert.assertEquals(techGlobalFileStaticTablesPage.rowInfo.get(i).getText(), headers[i]);
            System.out.println(techGlobalFileStaticTablesPage.rowInfo.get(i).getText());
        }
        int i = 0;
        for (WebElement e : techGlobalFileStaticTablesPage.rowInfo)
            Assert.assertEquals(e.getText(), headers[i++]);
    }
    @Test(priority = 2, description = "Validate 4th row data")
    public void validateColumn() {
        String[] columnData = {"USA", "China", "USA", "USA","S. Korea"};
        List<WebElement> tableColumn = TableData.getTableColumn(driver,4);
        IntStream.range(0,columnData.length).forEach(i->{
            System.out.println(tableColumn.get(i).getText());
            Assert.assertEquals(tableColumn.get(i).getText(), columnData[i]);
        });
    }
    @Test(priority = 2, description = "Validate first row of the table")
    public void validateRow(){
        String[] rowData = {"1", "Amazon", "1,523,000", "USA"};
        List<WebElement> tableRow = TableData.getTableRow(driver, 1);
        for (int i = 0; i < tableRow.size(); i++) {
            Assert.assertEquals(tableRow.get(i).getText(), rowData[i]);
        }
    }
    @Test(priority = 4, description = "validate all cells")
    public void validateAllCells(){
        List<List<WebElement>> tableData = techGlobalFileStaticTablesPage.getTableData();
        List<List<String>> table = new ArrayList<>();
        table.add(Arrays.asList("1","Amazon", "1,523,000" ,"USA"));
        table.add(Arrays.asList("2","Alibaba", "245,700" ,"China"));
        table.add(Arrays.asList("3","Microsoft", "221,000" ,"USA"));
        table.add(Arrays.asList("4","Apple", "154,000" ,"USA"));
        table.add(Arrays.asList("5","Samsung", "116,915" ,"S. Korea"));

        for (int i = 0; i < tableData.size(); i++) {
            for (int j = 0; j < tableData.get(i).size(); j++) {
                Assert.assertEquals(tableData.get(i).get(j).getText(), table.get(i).get(j));
            }
        }
    }
}

