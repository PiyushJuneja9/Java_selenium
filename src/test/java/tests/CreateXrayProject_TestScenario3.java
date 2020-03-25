//********************
//    Author of Code :- Piyush
//********************



package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.CreateProject;
import pages.Registration_page;
import utilities.ExtentReport;
import utilities.InvokeBrowser;
import utilities.LoadProperties;
import utilities.Locators;

public class CreateXrayProject_TestScenario3 {

	CreateProject createproject;
	Registration_page registration;

	@BeforeClass
	private void Setup() {
		
		ExtentReport.startTest(LoadProperties.config.getProperty("TN3"));
		
		registration = new Registration_page();
		createproject = new CreateProject();

		InvokeBrowser.OpenSite();
	}

	@Test(priority = 13)
	private void New_Registration() throws Throwable {
		
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
		registration.VerifyMail(LoadProperties.config.getProperty("Email"),
				LoadProperties.config.getProperty("EmailPassword"));

		message = registration.EnterPassword(LoadProperties.config.getProperty("password"));
		Assert.assertTrue(message.contains("Your password has been reset"));
		ExtentReport.test.log(LogStatus.PASS, "Password Set Successfully for " + LoadProperties.config.getProperty("user"));
	}

	@Test(priority = 14)
	private void login_ValidUserValidPass() throws Throwable {

		ExtentReport.test.log(LogStatus.INFO,
				"Login credentials is Username: " + LoadProperties.config.getProperty("user") + " and Password: "
						+ LoadProperties.config.getProperty("password"));

		createproject.login(LoadProperties.config.getProperty("user"), LoadProperties.config.getProperty("password"));
		createproject.DemoWait();
		
		String message = createproject.loginProfile(Locators.LoginMessage);
		Assert.assertTrue(message.contains(LoadProperties.config.getProperty("user")));

		ExtentReport.test.log(LogStatus.PASS, "Login Successfully");
	}

	@Test(priority = 15)
	private void CreateXrayProject() throws Throwable {

		createproject.Click(Locators.CloseButton);
		createproject.Click(Locators.OKButton);
		createproject.Click(Locators.Project);
		createproject.Click(Locators.CreateProject);
		
		ExtentReport.test.log(LogStatus.INFO, "Select Xray Test Project");
		Assert.assertTrue(createproject.Element(Locators.ScrumProject).isDisplayed());
		
		createproject.Click(Locators.XrayProject);
		createproject.Click(Locators.Next);
		createproject.Click(Locators.Select);
	}

	@Test(priority = 16)
	private void ProjectName() throws Throwable {

		createproject.DemoWait();
		ExtentReport.test.log(LogStatus.INFO, "Project Name: " + LoadProperties.config.getProperty("XrayProject_Name2"));
		Assert.assertTrue(createproject.Element(Locators.ProjectName).isEnabled());
		createproject.Name(LoadProperties.config.getProperty("XrayProject_Name2"));
		ExtentReport.test.log(LogStatus.PASS, "Xray Test Project Successfully Created");
	}

	@Test(priority = 17)
	private void UserStory() throws Throwable {

		createproject.Click(Locators.ListButton);
		createproject.Click(Locators.StoryButton);
		createproject.story(LoadProperties.config.getProperty("story3"));
		ExtentReport.test.log(LogStatus.PASS, "User Story Create Successfully");
	}
	
	@Test(priority = 18)
	private void Task() throws Throwable {
		
		createproject.DemoWait();
		 
		Assert.assertTrue(createproject.Element(Locators.CreateIssue).isDisplayed());
		createproject.Click(Locators.CreateIssue);
		createproject.Click(Locators.ListButton);
		createproject.Click(Locators.TaskButton);
		
		createproject.story(LoadProperties.config.getProperty("taskstory1"));
		ExtentReport.test.log(LogStatus.PASS, "Task 1 Successfully Created");
		
		createproject.DemoWait();
		createproject.story(LoadProperties.config.getProperty("taskstory2"));
		ExtentReport.test.log(LogStatus.PASS, "Task 2 Successfully Created");
	}

	@AfterClass
	private void logout() throws Throwable {
		
		createproject.DemoWait();
		
		ExtentReport.test.log(LogStatus.PASS, "LogOut Successfully "
				+ ExtentReport.test.addScreenCapture(ExtentReport.Screenshot(InvokeBrowser.driver)));
		createproject.logout();
		
		ExtentReport.endTest();
	}

}
