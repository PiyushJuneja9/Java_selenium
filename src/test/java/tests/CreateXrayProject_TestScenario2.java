package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.CreateProject;
import utilities.ExtentReport;
import utilities.InvokeBrowser;
import utilities.LoadProperties;
import utilities.Locators;

public class CreateXrayProject_TestScenario2 {

	CreateProject createproject;

	@BeforeClass
	private void Setup() {
		
		ExtentReport.startTest( LoadProperties.config.getProperty("TN2"));
		createproject = new CreateProject();
	}

	@Test(priority = 8)
	private void login_ValidUserValidPass() throws Throwable {

		createproject.Click(Locators.loginAgain);	
		ExtentReport.test.log(LogStatus.INFO,
				"Login credentials is Username: " + LoadProperties.config.getProperty("user") + " and Password: "
						+ LoadProperties.config.getProperty("password"));
		
		createproject.login(LoadProperties.config.getProperty("user"), LoadProperties.config.getProperty("password"));
		createproject.DemoWait();
		
		String message = createproject.loginProfile(Locators.LoginMessage);
		Assert.assertTrue(message.contains(LoadProperties.config.getProperty("user")));

		ExtentReport.test.log(LogStatus.PASS, "Login Successfully");
	}

	@Test(priority = 9) 
	private void CreateXrayProject() throws Throwable {

		createproject.Click(Locators.Project);
		createproject.Click(Locators.CreateProject);
		
		ExtentReport.test.log(LogStatus.INFO, "Select Xray Test Project");
		Assert.assertTrue(createproject.Element(Locators.ScrumProject).isDisplayed());
		
		createproject.Click(Locators.XrayProject);
		createproject.Click(Locators.Next);
		createproject.Click(Locators.Select);
	}

	@Test(priority = 10)
	private void ProjectName() throws Throwable {

		createproject.DemoWait();
		ExtentReport.test.log(LogStatus.INFO, "Project Name: " + LoadProperties.config.getProperty("XrayProject_name1"));
		Assert.assertTrue(createproject.Element(Locators.ProjectName).isEnabled());
		createproject.Name(LoadProperties.config.getProperty("XrayProject_name1"));
		ExtentReport.test.log(LogStatus.PASS, "Xray Test Project Successfully Created");
	}

	@Test(priority = 11)
	private void UserStory() throws Throwable {
		
		createproject.Click(Locators.ListButton);
		createproject.Click(Locators.StoryButton);
		createproject.story(LoadProperties.config.getProperty("story2"));
		ExtentReport.test.log(LogStatus.PASS, "User Story Create Successfully");
	}
	
	@Test(priority = 12)
	private void Plan() throws Throwable {
		
		createproject.DemoWait();
		
		Assert.assertTrue(createproject.Element(Locators.CreateIssue).isDisplayed());
		createproject.Click(Locators.CreateIssue);
		createproject.Click(Locators.ListButton);
		createproject.Click(Locators.PlanButton);
		
		createproject.story(LoadProperties.config.getProperty("planstory1"));
		ExtentReport.test.log(LogStatus.PASS, "Plan Successfully Created");
		createproject.DemoWait();
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
