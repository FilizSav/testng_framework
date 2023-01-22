package testng_knowledge;

import org.testng.annotations.*;

public class _01_Annotations {
    @BeforeTest
    public void beforeTest(){
        System.out.println("The test is completed, this is before Test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("The test is completed, this is after Test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println(getClass().getSimpleName() + "testing started!");
    }
    @AfterClass
    public void afterClass(){
        System.out.println(getClass().getSimpleName() + "testing is complete!");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is Before Method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("This is After Method");
    }
    @Test
    public void test1(){
        System.out.println("This is test case 1");
    }
    @Test
    public void test2() {
        System.out.println("This is test case 2");
    }
}
