package project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



public class Class3 extends BaseClass{
	@Test
	public void sortFilter() throws Exception {
		ExtentReports extent=ExtentReportManager.getReport();
		ExtentTest test=extent.createTest("Sort Filter");
		test.info("Test Started");
		test.info("Entering search term: ");
		driver.findElement(By.id("searchV2")).sendKeys("Refrigerator"+Keys.ENTER);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='selected-item']"))).click();
		test.info("Selecting the option Discount (Descending)");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Discount (Descending)']"))).click();
		wait.until(ExpectedConditions.urlContains(("discount")));
		Assert.assertTrue(driver.getCurrentUrl().contains("discount"));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[text()='Off']")));
		List<WebElement> discount=driver.findElements(By.xpath("//*[text()='Off']"));
		int d1=Integer.parseInt(discount.get(0).getText().replace("% Off", ""));
		int d2=Integer.parseInt(discount.get(1).getText().replace("% Off",""));
		Assert.assertTrue(d1>=d2);
		test.pass("Test completed");
		screenshot("Class3_Sort_Filter");
		test.addScreenCaptureFromPath("screenshots/Class3_Sort_Filter.png");
		extent.flush();

	}

}
