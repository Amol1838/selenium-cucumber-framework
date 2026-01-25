package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getExtentReport() {
		
		if(extent == null) {
			ExtentSparkReporter spark=new ExtentSparkReporter("target/ExtentReport.html");
			extent=new ExtentReports();
			extent.attachReporter(spark);
		}
		return extent;
	}

}
