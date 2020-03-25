//********************
//    Author of Code :- Jyoti
//********************

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.InvokeBrowser;
import utilities.Locators;

public class CreateProject {

	public void login(String strUserName, String strPasword) {

		InvokeBrowser.driver.findElement(Locators.UserName).sendKeys(strUserName);
		InvokeBrowser.driver.findElement(Locators.Password).sendKeys(strPasword);
		InvokeBrowser.driver.findElement(Locators.login).click();
		InvokeBrowser.driver.switchTo().window(Registration_page.tabs.get(0));
	}

	public void Click(By locator) throws Throwable {

		ElementWait(locator);
		InvokeBrowser.driver.findElement(locator).click();
		DemoWait();
	}

	public void MouseHover(By locator) throws Throwable {

		ElementWait(locator);
		Actions action = new Actions(InvokeBrowser.driver);
		action.moveToElement(Element(locator)).click().perform();
		DemoWait();
	}

	public void Name(String name) throws Throwable {

		InvokeBrowser.driver.findElement(Locators.ProjectName).sendKeys(name);
		DemoWait();
		InvokeBrowser.driver.findElement(Locators.SubmitButton).click();
	}

	public void story(String story) {

		ElementWait(Locators.UserStoryField);
		InvokeBrowser.driver.findElement(Locators.UserStoryField).sendKeys(story);
		InvokeBrowser.driver.findElement(Locators.UserStoryField).sendKeys(Keys.ENTER);
	}

	public void ConfigureIssueType() throws Throwable {

		Click(Locators.Setting);
		Click(Locators.CrossButton);
		MouseHover(Locators.ActionButton);
		Click(Locators.AddIssue);
		Click(Locators.IssuePage);
	}

	public void CreateCase(String steps, String data, String result) throws Throwable {

		ElementWait(Locators.CaseStep);
		InvokeBrowser.driver.findElement(Locators.CaseStep).sendKeys(steps);
		InvokeBrowser.driver.findElement(Locators.CaseDataSet).sendKeys(data);
		InvokeBrowser.driver.findElement(Locators.CaseExpectedResult).sendKeys(result);
		Click(Locators.CaseAddButton);
	}

	public void logout() {

		InvokeBrowser.driver.findElement(Locators.ProfileButton).click();
		InvokeBrowser.driver.findElement(Locators.LogoutButton).click();
		InvokeBrowser.driver.switchTo().window(Registration_page.tabs.get(0));
	}

	public String loginProfile(By locator) {

		return InvokeBrowser.driver.findElement(locator).getAttribute("alt");
	}

	public WebElement Element(By locator) {

		return InvokeBrowser.driver.findElement(locator);
	}

	public void ElementWait(By locator) {

		WebDriverWait wait = new WebDriverWait(InvokeBrowser.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void DemoWait() throws Throwable {

		Thread.sleep(3000);
	}

}
