package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Class3 extends BaseClass{
	@DataProvider (name="Factorial")
	public Object[][] data() throws Exception{
		FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testdata/ProjectExcel.xls");
		Workbook wb=Workbook.getWorkbook(f);
		Sheet s=wb.getSheet("Sheet");
		int rows=s.getRows();
		Object[][] obj=new Object[rows][1];
		 for (int i = 0; i < rows; i++) {
	            String celldata = s.getCell(0, i).getContents(); 
	            obj[i][0] = celldata; 
	            System.out.println(celldata);
		 }
		return obj;
		 }
	@Test (dataProvider = "Factorial")
	public void dataEntry(String number) throws Exception {
		driver.findElement(By.id("number")).clear();
		driver.findElement(By.id("number")).sendKeys(number);
		driver.findElement(By.id("getFactorial")).click();
		Thread.sleep(3000);
		String resulttext=driver.findElement(By.id("resultDiv")).getText();
		String actualresult=resulttext.split(":")[1].trim();
		int actual=Integer.parseInt(actualresult);
		int expected=factorial(Integer.parseInt(number));
		Assert.assertEquals(actual, expected);		
	}
	public int factorial(int n) {
		int fact=1;
		for(int i=1;i<=n;i++) {
			fact=fact*i;
		}
		return fact;
	}
	

}
