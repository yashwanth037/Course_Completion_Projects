package project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Class4 extends BaseClass{
	@Test
	public void aboutPageValidation() {
		driver.findElement(By.xpath("//*[text()='About']")).click();
		List<WebElement> lc=driver.findElements(By.tagName("a"));
		System.out.println(lc.size());
		for(WebElement data:lc) {
			System.out.println(data.getText());
		}
		Assert.assertTrue(lc.size()>5);
	}

}
