//********************
//    Author of Code :- Shikha and jyoti
//********************



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

public class CreateProject_TestScenario4 {

	CreateProject createproject;
 
	@BeforeClass
	private void Setup() throws InterruptedException {

		ExtentReport.startTest(LoadProperties.config.getProperty("TN4"));
		
		createproject = new CreateProject();
	}

	@Test(priority = 19)
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

	@Test(priority = 20)
	private void NewProject() throws Throwable {

		createproject.Click(Locators.Project);
		createproject.Click(Locators.CreateProject);
		
		ExtentReport.test.log(LogStatus.INFO, "Select Scrum Software Development Project");
		Assert.assertTrue(createproject.Element(Locators.ScrumProject).isDisplayed());
		
		createproject.Click(Locators.ScrumProject);
		createproject.Click(Locators.Next);
		createproject.Click(Locators.Select);
	}

	@Test(priority = 21)
	private void ProjectName() throws Throwable {

		createproject.DemoWait();
		ExtentReport.test.log(LogStatus.INFO, "Project Name: " + LoadProperties.config.getProperty("Project_Name2"));
		Assert.assertTrue(createproject.Element(Locators.ProjectName).isEnabled());
		createproject.Name(LoadProperties.config.getProperty("Project_Name2"));
		ExtentReport.test.log(LogStatus.PASS, "Scrum Project Successfully Created");
	}

	@Test(priority = 22)
	private void UserStory() throws Throwable {
		
		createproject.Click(Locators.ListButton);
		createproject.Click(Locators.StoryButton);
		createproject.story(LoadProperties.config.getProperty("story4"));
		ExtentReport.test.log(LogStatus.PASS, "User Story Create Successfully");
	}
	
	@Test(priority = 23)
	private void TestCase() throws Throwable {

		createproject.DemoWait();
		
		createproject.ConfigureIssueType();
		
		Assert.assertTrue(createproject.Element(Locators.CreateIssue).isDisplayed());
		createproject.Click(Locators.CreateIssue); 
		createproject.Click(Locators.ListButton);
		createproject.Click(Locators.TestButton);

		createproject.story(LoadProperties.config.getProperty("teststory1"));
		createproject.CreateCase(LoadProperties.config.getProperty("casestep"),
				LoadProperties.config.getProperty("casedata"), LoadProperties.config.getProperty("caseresult"));
		ExtentReport.test.log(LogStatus.PASS, "Test Successfully Created");
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
