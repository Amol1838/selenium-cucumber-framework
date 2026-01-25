package hooks;

import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.DriverFactory;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class Hooks {
	
	ExtentReports extent=ExtentManager.getExtentReport();
	ExtentTest test;
	
	@Before
	public void setup(Scenario scenario) {
		WebDriverManager.chromedriver().setup();
		DriverFactory.setDriver(new ChromeDriver());
		test=extent.createTest(scenario.getName());
		DriverFactory.getDriver().manage().window().maximize();
	}
	
	@AfterStep
	public void afterStep(Scenario scenario) {
		if(scenario.isFailed()) {
			String path=ScreenshotUtil.captureScreenshot(scenario.getName());
			test.fail("step failed",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			test.fail(scenario.getStatus().toString());
		}
		else {
			test.pass("scenario passed");
		}
		extent.flush();
		DriverFactory.quitDriver();
	}

}
