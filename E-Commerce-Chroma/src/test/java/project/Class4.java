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

public class Class4 extends BaseClass{
	
	@Test
	public void priceCalculation() throws Exception {
		ExtentReports extent=ExtentReportManager.getReport();
		ExtentTest test=extent.createTest("Price Calculation");
		test.info("Test Started");
		test.info("Entering search term: ");
		driver.findElement(By.id("searchV2")).sendKeys("Refrigerator"+Keys.ENTER);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.className("selected-item"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Discount (Descending)']"))).click();
		wait.until(ExpectedConditions.urlContains(("discount")));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[text()='Off']")));
		List<WebElement> prices=driver.findElements(By.xpath("//*[@data-testid=\"new-price\"]"));
		int count=0;
		int sum=0;
		test.info("Calculating average price");
		for(WebElement price:prices) {
			if(count==10)
				break;
			String pricetext=price.getText().replace("₹","").replace(",","");
			int value=Integer.parseInt(pricetext);
			sum=sum+value;
			count++;
			
		}
		int avg=sum/count;
		System.out.println(avg);
		screenshot("Class4_Price_Calculation");
		test.addScreenCaptureFromPath("screenshots/Class4_Price_Calculation.png");
		test.pass("Test completed");
		extent.flush();
	}
	

}
