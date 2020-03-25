package utilities;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport {

	public static ExtentTest test;
	public static ExtentReports report;

	public ExtentReport(String name) {
		
		report = new ExtentReports(System.getProperty("user.dir") + "\\Reports\\"+ name +".html");
	}
	
	public static void startTest(String testname) {
		test = report.startTest(testname, testname);
	}

	public static void endTest() {
		report.endTest(test);
	}
	
	public static void reportflush() {
	
		report.flush();
	}
	
	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", element);
	}
	
	public static String Screenshot(WebDriver driver) throws Throwable {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") +"\\Screenshot\\" + System.currentTimeMillis() + "_sshot.png";
		Files.copy(screenshotFile, new File(path));
		return path;
	}
	
		
}
