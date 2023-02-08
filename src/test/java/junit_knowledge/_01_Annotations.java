package junit_knowledge;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _01_Annotations {

    @BeforeMethod
    public void setUp(){
        System.out.println("This is JUnit Before method annotation");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("This is JUnit After method annotation");
    }
    @Test
    public void test1(){
        System.out.println("This is JUnit Test annotation 1");
        //JUnit assert equal expected than actual
    }
    @Test
    public void a(){
        System.out.println("This is JUnit Test annotation 2");
    }

}
