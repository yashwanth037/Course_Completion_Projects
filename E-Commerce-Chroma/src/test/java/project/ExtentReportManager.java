package project;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	 static ExtentReports extent;
	
	    public static ExtentReports getReport() {
	        if (extent == null) {
	            ExtentSparkReporter reporter=new ExtentSparkReporter("reports/AutomationReport.html");
	            extent = new ExtentReports();
	            extent.attachReporter(reporter);
	        }
	        return extent;
	    }
	

}
