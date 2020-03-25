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
import utilities.ExtentReport;
import utilities.InvokeBrowser;
import utilities.LoadProperties;
import utilities.Locators;

public class CreateProject_TestScenario1 {

	CreateProject createproject;

	@BeforeClass
	private void Setup() throws InterruptedException {

		createproject = new CreateProject();
	}

	@Test(priority = 3)
	private void login_ValidUserValidPass() throws Throwable {

		ExtentReport.test.log(LogStatus.INFO,
				"Login credentials is Username: " + LoadProperties.config.getProperty("user") + " and Password: "
						+ LoadProperties.config.getProperty("password"));

		createproject.login(LoadProperties.config.getProperty("user"), LoadProperties.config.getProperty("password"));
		createproject.DemoWait();

		String message = createproject.loginProfile(Locators.LoginMessage);
		Assert.assertTrue(message.contains(LoadProperties.config.getProperty("user")));

		ExtentReport.test.log(LogStatus.PASS, "LogIn Successfully");
	}

	@Test(priority = 4)
	private void NewProject() throws Throwable {

		createproject.Click(Locators.CloseButton);
		createproject.Click(Locators.OKButton);
		createproject.Click(Locators.Project);
		createproject.Click(Locators.CreateProject);

		ExtentReport.test.log(LogStatus.INFO, "Select Scrum Software Development Project");
		Assert.assertTrue(createproject.Element(Locators.ScrumProject).isDisplayed());

		createproject.Click(Locators.ScrumProject);
		createproject.Click(Locators.Next);
		createproject.Click(Locators.Select);
	}

	@Test(priority = 5)
	private void ProjectName() throws Throwable {

		createproject.DemoWait();
		ExtentReport.test.log(LogStatus.INFO, "Project Name: " + LoadProperties.config.getProperty("Project_Name1"));
		Assert.assertTrue(createproject.Element(Locators.ProjectName).isEnabled());
		createproject.Name(LoadProperties.config.getProperty("Project_Name1"));
		ExtentReport.test.log(LogStatus.PASS, "Scrum Project Successfully Created");
	}

	@Test(priority = 6)
	private void UserStory() throws Throwable {

		createproject.Click(Locators.ListButton);
		createproject.Click(Locators.StoryButton);
		createproject.story(LoadProperties.config.getProperty("story1"));
		ExtentReport.test.log(LogStatus.PASS, "User Story Create Successfully");
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
