package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class TechGlobalFileStaticTablesPage extends TechGlobalBasePage{
    public TechGlobalFileStaticTablesPage(){super();}

    @FindBy(css = ".header")
    public List<WebElement> tableHeaders;

    @FindBy(xpath = "//td[2]")
    public List<WebElement> rowInfo;

    @FindBy(css = "tbody td:nth-child(1)")
    public List<WebElement> tableColumn;

    public List<List<WebElement>> getTableData(){
        List<List<WebElement>> tableData = new ArrayList<>();

        for (int i = 1; i <= tableColumn.size(); i++) {
            tableData.add(Driver.getDriver().findElements(By.cssSelector("tbody>tr:nth-child("+ i +") td")));
        }
        return tableData;
    }
}
