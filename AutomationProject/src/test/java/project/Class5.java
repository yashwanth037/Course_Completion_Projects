package project;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Class5 extends BaseClass {

    @Test
    public void bugValidation() throws Exception {
        driver.findElement(By.name("number")).sendKeys("-5");
        Thread.sleep(2000);
        driver.findElement(By.id("getFactorial")).click();
        Thread.sleep(2000);
        String actualresult=driver.findElement(By.id("resultDiv")).getText();
        String expectedresult="Please enter an integer";
        assertEquals(actualresult, expectedresult);
        
		
    }
}
