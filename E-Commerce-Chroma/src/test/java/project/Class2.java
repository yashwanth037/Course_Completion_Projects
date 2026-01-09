package project;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Class2 extends BaseClass {
	@Test
	public void brandFiltering() throws Exception {
		ExtentReports extent = ExtentReportManager.getReport();

		ExtentTest test=extent.createTest("Brand Filtering");
		test.info("Test Started");
		test.info("Entering search term: ");
	    driver.findElement(By.id("searchV2")).sendKeys("Refrigerator" + Keys.ENTER);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Brand'])[1]"))).click();
	    
	    test.info("Selecting brand filters");
	    wait.until(ExpectedConditions .elementToBeClickable(By.xpath("//*[text()='LG']"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Samsung']"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Whirlpool']"))).click();
	    Thread.sleep(2000);
	    String url=driver.getCurrentUrl();
	    System.out.println(url);
	    Assert.assertTrue(driver.getCurrentUrl().contains("Brand"));
	    test.pass("Test completed");
	    screenshot("Class2_Brand_Filtering");
	    test.addScreenCaptureFromPath("screenshots/Class2_Brand_Filtering.png");
	    extent.flush();
	}

}
