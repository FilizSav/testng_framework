package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDynamicTablesPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.TableData;
import utilities.TextHandler;

import java.util.List;
import java.util.stream.IntStream;

public class TechGlobalDynamicTablesTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDynamicTablesPage = new TechGlobalDynamicTablesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Dynamic Tables");
    }
    @Test(priority = 1, description = "Validate popUp Validation")
    public void popUpValidation(){
        techGlobalDynamicTablesPage.addProductButton.click();
        Assert.assertEquals(techGlobalDynamicTablesPage.modalCardTitle.getText(),"Add New Product");
    }
    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on “Practices” dropdown in the header
     * Select the “Frontend Testing” option
     * Click on the “Dynamic Tables” card
     * Click the “Add Product” button
     * Enter “2” in the Quantity field
     * Enter “Apple Watch” in the Product field
     * Enter “500” in the Price $ field
     * Click the “Submit” button
     * Verify that a new row has been added to the table with the values “2”, “Apple Watch, “500” and the calculated Total $ value is “1,000"
     * Verify that the Total $ value at the bottom of the table has been updated to reflect the total cost of all the products in the table, including the newly added one.
     */
    @Test(priority = 2, description = "Validate dynamic table")
    public void validateDynamicTable(){
        techGlobalDynamicTablesPage.addProductButton.click();
        //store the current total amount before adding a new product and parse it to an int
        int initialTotal = TextHandler.getInt(techGlobalDynamicTablesPage.totalAmount.getText());

        Assert.assertEquals(techGlobalDynamicTablesPage.modalCardTitle.getText(), "Add New Product");
        String[] products = {"2", "Apple Watch", "500"};
        int tableRowSize = techGlobalDynamicTablesPage.tableRow.size();
        Assert.assertEquals(techGlobalDynamicTablesPage.tableRow.size(), 3);
        int myProductTotal = TextHandler.getInt(products[0]) * TextHandler.getInt(products[2]);
        IntStream.range(0, products.length).forEach(i -> techGlobalDynamicTablesPage.productDetails.get(i).sendKeys(products[i]));
        techGlobalDynamicTablesPage.submitButton.click();
        Assert.assertEquals(techGlobalDynamicTablesPage.tableRow.size(), tableRowSize + 1);
        int productTotal = TextHandler.getInt(TableData.getTableRow(driver, 4).get(3).getText());
        List<WebElement> tableRow = TableData.getTableRow(driver,4);
        IntStream.range(0,tableRow.size()-1).forEach(i-> Assert.assertEquals(tableRow.get(i).getText(),products[i]));
        Assert.assertEquals(productTotal,myProductTotal);
        int newTotal = TextHandler.getInt(techGlobalDynamicTablesPage.totalAmount.getText());
        int expectedTotal = initialTotal + myProductTotal;
        Assert.assertEquals(newTotal,expectedTotal);
    }

    @Test(priority = 3, description = "Validate dynamic table")
    public void validateDynamicTable2(){

        // storing initial table row size and validate it is 3
        int tableRowSize = TableData.getRowCount(techGlobalDynamicTablesPage.table);
        System.out.println(tableRowSize);
        Assert.assertEquals(tableRowSize, 3);

        // store the current total amount before adding a new product and parse it to an int
        int initialTotal = TextHandler.getInt(techGlobalDynamicTablesPage.totalAmount.getText());
        techGlobalDynamicTablesPage.addProductButton.click();


        // validate that the modal card is displayed by its title
        Assert.assertEquals(techGlobalDynamicTablesPage.modalCardTitle.getText(), "Add New Product");

        // storing all the products in an array so we can add it
        String[] products = {"2", "Apple Watch", "2,000"};

        // calculate the total amount of the new product by multiplying quantity with price
        int myProductTotal = TextHandler.getInt(products[0]) * TextHandler.getInt(products[2]) ;

        // enter the values from the products array into the corresponding input fields
        IntStream.range(0, products.length).forEach(i -> techGlobalDynamicTablesPage.productDetails.get(i).sendKeys(products[i]));

        // submit the form to add the new product to our table
        techGlobalDynamicTablesPage.submitButton.click();

        // then validate that there are now 4 rows in the table.
        Assert.assertEquals(TableData.getRowCount(techGlobalDynamicTablesPage.table), tableRowSize + 1);

        // get the total amount of the newly added product from the table
        int productTotalAmount = TextHandler.getInt(TableData.getTableRow(driver, 4).get(3).getText());

        // get the row of the table that we need to check



        // validate that the values in the table match the values from product array
        IntStream.range(0, products.length).forEach(i -> Assert.assertEquals(TableData.getRowCell(techGlobalDynamicTablesPage.table, 3, i).getText(), products[i]));

        // Also, validate that the total amount of the newly added product matches the calculated value
        Assert.assertEquals(productTotalAmount, myProductTotal);

        // get the final total amount from the table.
        int newTotal = TextHandler.getInt(techGlobalDynamicTablesPage.totalAmount.getText());

        // calculate the expected total amount by adding the total of the newly added product to the initial total
        int expectedTotal = initialTotal + myProductTotal;

        // validate that the current total matches the expected total
        Assert.assertEquals(newTotal, expectedTotal);
    }
}
