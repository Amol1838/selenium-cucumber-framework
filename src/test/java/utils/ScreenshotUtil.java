package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtil {
	
	public static String captureScreenshot(String testName) {
		
		try{
			File src = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		    String path= "target/screenshots/"+testName+".png";
		    FileUtils.copyFile(src, new File(path));
		    return path;
		}
		catch(Exception e) {
			return null;
		}
	}

}
