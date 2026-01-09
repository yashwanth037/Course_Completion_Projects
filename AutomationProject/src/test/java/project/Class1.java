package project;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Class1 extends BaseClass  {
	@Test
	public void uivalidation() {
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"number\"]")).isDisplayed());
	    Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Calculate!']")).isEnabled()); 
	    Assert.assertTrue(driver.findElement(By.xpath("//*[text()='About']")).isEnabled());
	    Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Terms and Conditions']")).isEnabled());
	    Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Privacy']")).isEnabled());
	}

}
