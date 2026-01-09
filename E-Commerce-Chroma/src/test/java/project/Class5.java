package project;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Class5 extends BaseClass {

    @Test
    public void cartFunctionality() throws Exception {

        ExtentReports extent = ExtentReportManager.getReport();
        ExtentTest test = extent.createTest("Add to Cart Functionality");
        test.info("Test Started");
        test.info("Searching for Refrigerator");
        driver.findElement(By.id("searchV2")) .sendKeys("Refrigerator" + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        test.info("Selecting the product");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='product-info'])[1]"))).click();
        Set<String> wc=driver.getWindowHandles();
        for(String ref:wc) {
        	driver.switchTo().window(ref);
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Without Exchange']"))).click();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(300,600)");
        test.info("Adding product into cart");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Add to Cart']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Proceed to Cart']"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
        Thread.sleep(3000);
        test.pass("Test Completed");
        screenshot("Class_5_Add to Cart");
        test.addScreenCaptureFromPath("screenshots/Class_5_Add to Cart.png");
        extent.flush();
    }
}
