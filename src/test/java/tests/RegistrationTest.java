package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.Registration_page;
import utilities.ExtentReport;
import utilities.LoadProperties;
import utilities.Locators;

public class RegistrationTest {

	Registration_page registration;

	@BeforeClass
	@Parameters("Browser")
	public void setup(String Browser) throws Throwable {
		
		if (Browser.equalsIgnoreCase("Chrome")) {
			LoadProperties.property("config1");
			ExtentReport ER= new ExtentReport("ExtentReportResult1");
		}
		else {
			LoadProperties.property("config2");
			ExtentReport ER= new ExtentReport("ExtentReportResult2");
		}
		
		ExtentReport.startTest(LoadProperties.config.getProperty("TN1"));
 
		registration = new Registration_page();
		ExtentReport.test.log(LogStatus.PASS, "Chrome Browser launch sucessfully");
		ExtentReport.test.log(LogStatus.INFO, "Navigated to " + LoadProperties.config.getProperty("URL"));
		registration.LaunchSandbox(Browser);
		ExtentReport.test.log(LogStatus.PASS, "Sandbox Site launch sucessfully");
	}

	@Test(priority = 0)
	private void SandBox() {
		
		try {
		ExtentReport.test.log(LogStatus.INFO, "Get the Website Title");
		String actaltitle = registration.Title();
		Assert.assertEquals(actaltitle,LoadProperties.config.getProperty("ExpectedTitle"));
		ExtentReport.test.log(LogStatus.PASS, "Sandbox Title Verfied");
		}catch (Throwable e) {
			ExtentReport.test.log(LogStatus.FAIL, " Sandbox Title is Not True");
		}
	}

	@Test(priority = 1)
	private void Register_ValidUserValidPass() {
		
		ExtentReport.test.log(LogStatus.INFO,
				"New Registration credentials is Username: " + LoadProperties.config.getProperty("firstName") + " "
						+ LoadProperties.config.getProperty("lastName") + ", Company Name:  "
						+ LoadProperties.config.getProperty("companyName") + ", Email: "
						+ LoadProperties.config.getProperty("Email"));

		registration.register(LoadProperties.config.getProperty("firstName"),
				LoadProperties.config.getProperty("lastName"), LoadProperties.config.getProperty("companyName"),
				LoadProperties.config.getProperty("Email"));

		String message = registration.Message(Locators.RegistrationMessage);
		Assert.assertTrue(message.contains(LoadProperties.config.getProperty("Email")));

		ExtentReport.test.log(LogStatus.PASS, "Submitted Successfully");
	}

	@Test(priority = 2)
	private void SetPassword() {

		registration.VerifyMail(LoadProperties.config.getProperty("Email"),
				LoadProperties.config.getProperty("EmailPassword"));
		
		String message = registration.EnterPassword(LoadProperties.config.getProperty("password"));
		Assert.assertTrue(message.contains("Your password has been reset"));
		ExtentReport.test.log(LogStatus.PASS, "Password Set Successfully for " + LoadProperties.config.getProperty("user"));
	}
}
