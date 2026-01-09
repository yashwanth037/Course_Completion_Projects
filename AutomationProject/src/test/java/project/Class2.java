package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Class2 extends BaseClass {
	@Test ()
	public void check() {
		 WebElement textbox=driver.findElement(By.tagName("input"));
		 String placeholdertext=textbox.getAttribute("placeholder");
		 Assert.assertEquals(placeholdertext, "Enter an integer");
		 Assert.assertTrue(driver.getTitle().contains("Factorial"));
		 Assert.assertTrue(driver.getCurrentUrl().contains("https"));
	}

}
 