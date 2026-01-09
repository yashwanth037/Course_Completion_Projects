package project;



import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import jxl.Sheet;
import jxl.Workbook;

public class Class1 extends BaseClass {
	@DataProvider(name = "Searching")
	public Object[][] textSearch() throws Exception {
		FileInputStream f = new FileInputStream(System.getProperty("user.dir") +"/src/test/resources/testdata/ChromaProject.xls");

		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet("Sheet");
		int rows = s.getRows();
		Object[][] obj = new Object[rows][1];
		for (int i = 0; i < rows; i++) {
			String celldata = s.getCell(0, i).getContents();
			obj[i][0] = celldata;
			System.out.println(celldata);
		}
		return obj;

	}

	@Test(dataProvider = "Searching")
	public void dataEntry(String data) throws Exception {
		ExtentReports extent = ExtentReportManager.getReport();
		ExtentTest test = extent.createTest("Search Functionality Test");
		test.info("Test started");
		test.info("Entering search term: ");
		driver.findElement(By.id("searchV2")).sendKeys(data + Keys.ENTER);
		Thread.sleep(2000);
	
		Assert.assertTrue(driver.getTitle().contains("Refrigerator"));
		test.pass("Search results validated successfully");

		screenshot("Class1_Search_Functionality");
		test.addScreenCaptureFromPath("screenshots/Class1_Search_Functionality.png");


		test.pass("Test completed");
		extent.flush();

	

	}

}
