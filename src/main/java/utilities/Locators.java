//********************
//    Author of Code :- Shikha
//********************



package utilities;

import org.openqa.selenium.By;

public class Locators extends LoadProperties {

	// New Registration
	public static By FirstName = By.xpath(LoadProperties.orXpath.getProperty("First_name"));
	public static By LastName = By.xpath(LoadProperties.orXpath.getProperty("Last_name"));
	public static By CompanyName = By.xpath(LoadProperties.orXpath.getProperty("company_name"));
	public static By Email = By.xpath(LoadProperties.orXpath.getProperty("email"));
	public static By Authorization = By.xpath(LoadProperties.orXpath.getProperty("authorize"));
	public static By Submit = By.xpath(LoadProperties.orXpath.getProperty("submit"));
	
	public static By RegistrationMessage = By.xpath(LoadProperties.orXpath.getProperty("Message1"));

	// Reset Password
	public static By Pass = By.xpath(LoadProperties.orXpath.getProperty("pass"));
	public static By Confirm = By.xpath(LoadProperties.orXpath.getProperty("confirm"));
	public static By ResetButton = By.xpath(LoadProperties.orXpath.getProperty("reset"));
	
	public static By ResetPasswordMessage = By.xpath(LoadProperties.orXpath.getProperty("Message2"));

	// Login
	public static By UserName = By.xpath(LoadProperties.orXpath.getProperty("username"));
	public static By Password = By.xpath(LoadProperties.orXpath.getProperty("password"));
	public static By RememberLogin = By.xpath(LoadProperties.orXpath.getProperty("rememberLogin"));
	public static By login = By.xpath(LoadProperties.orXpath.getProperty("Login"));
	
	public static By LoginMessage = By.xpath(LoadProperties.orXpath.getProperty("Message3"));	

	// Create Project
	public static By CloseButton = By.xpath(LoadProperties.orXpath.getProperty("CloseButton"));
	public static By OKButton = By.xpath(LoadProperties.orXpath.getProperty("OKButton"));

	public static By Project = By.xpath(LoadProperties.orXpath.getProperty("project"));
	public static By CreateProject = By.xpath(LoadProperties.orXpath.getProperty("createProject"));
	public static By ScrumProject = By.xpath(LoadProperties.orXpath.getProperty("ScrumProject"));

	public static By XrayProject = By.xpath(LoadProperties.orXpath.getProperty("xrayProject"));
	public static By Next = By.xpath(LoadProperties.orXpath.getProperty("next"));
	public static By Select = By.xpath(LoadProperties.orXpath.getProperty("select"));
	public static By ProjectName = By.xpath(LoadProperties.orXpath.getProperty("name"));
	public static By SubmitButton = By.xpath(LoadProperties.orXpath.getProperty("submitbutton"));

	//Create Story and Issues 
	public static By UserStoryField = By.xpath(LoadProperties.orXpath.getProperty("usertext1"));
	
	public static By IssuePage = By.xpath(LoadProperties.orXpath.getProperty("issuepage"));
	public static By CreateIssue = By.xpath(LoadProperties.orXpath.getProperty("createissue"));
	public static By StoryButton = By.xpath(LoadProperties.orXpath.getProperty("storybutton"));
	public static By ListButton = By.xpath(LoadProperties.orXpath.getProperty("listbutton"));
	public static By PlanButton = By.xpath(LoadProperties.orXpath.getProperty("planbutton"));
	public static By TaskButton = By.xpath(LoadProperties.orXpath.getProperty("taskbutton"));
	public static By TestButton = By.xpath(LoadProperties.orXpath.getProperty("testbutton"));
	public static By TestSetButton = By.xpath(LoadProperties.orXpath.getProperty("testsetbutton"));	
	
	//Create Test
	public static By CaseStep = By.xpath(LoadProperties.orXpath.getProperty("caseStep"));
	public static By CaseDataSet = By.xpath(LoadProperties.orXpath.getProperty("caseDataSet"));
	public static By CaseExpectedResult = By.xpath(LoadProperties.orXpath.getProperty("caseExpectedResult"));	
	public static By CaseAddButton = By.xpath(LoadProperties.orXpath.getProperty("caseaddbutton"));		
	
	//Setting to Configure Project
	public static By Setting = By.xpath(LoadProperties.orXpath.getProperty("setting"));
	public static By ActionButton = By.xpath(LoadProperties.orXpath.getProperty("actionbutton"));
	public static By AddIssue = By.xpath(LoadProperties.orXpath.getProperty("addissue"));

	//Logout Profile
	public static By ProfileButton = By.xpath(LoadProperties.orXpath.getProperty("profilebutton"));
	public static By LogoutButton = By.xpath(LoadProperties.orXpath.getProperty("logoutbutton"));
	
	public static By loginAgain = By.xpath(LoadProperties.orXpath.getProperty("loginagain"));
	public static By CrossButton = By.xpath(LoadProperties.orXpath.getProperty("crossbutton"));
	
}
