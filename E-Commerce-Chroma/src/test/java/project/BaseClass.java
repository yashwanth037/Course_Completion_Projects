package project;

import java.io.File;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.google.common.io.Files;

public class BaseClass {
	WebDriver driver;

	@BeforeMethod
	public void launchApp() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.croma.com/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

	public void screenshot(String name) throws Exception {

	    String path = System.getProperty("user.dir") + "/reports/screenshots/";

	    File dir = new File(path);
	    if (!dir.exists()) {
	        dir.mkdirs();   // creates reports/screenshots
	    }

	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File dest = new File(path + name + ".png");
	    Files.copy(src, dest);
	}
}
