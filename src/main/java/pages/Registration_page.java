package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import utilities.Email;
import utilities.InvokeBrowser;
import utilities.Locators;

public class Registration_page {

	public static ArrayList<String> tabs;

	public void LaunchSandbox(String Browser) {

		InvokeBrowser.Launch(Browser);
	}

	public String Title() {

		return InvokeBrowser.driver.getTitle();
	}

	public void register(String strFirstName, String strLastName, String strCompanyName, String strEmail) {

		InvokeBrowser.driver.switchTo().frame("gadget-12500");
		InvokeBrowser.driver.findElement(Locators.FirstName).sendKeys(strFirstName);
		InvokeBrowser.driver.findElement(Locators.LastName).sendKeys(strLastName);
		InvokeBrowser.driver.findElement(Locators.CompanyName).sendKeys(strCompanyName);
		InvokeBrowser.driver.findElement(Locators.Email).sendKeys(strEmail);
		InvokeBrowser.driver.findElement(Locators.Authorization).click();
		InvokeBrowser.driver.findElement(Locators.Submit).click();
	}

	public void VerifyMail(String email, String password) {

		((JavascriptExecutor) InvokeBrowser.driver).executeScript("window.open()");
		tabs = new ArrayList<String>(InvokeBrowser.driver.getWindowHandles());
		String URL = Email.VerifyEmail(email, password);
		InvokeBrowser.driver.switchTo().window(tabs.get(1));
		InvokeBrowser.driver.get(URL);
	}

	public String EnterPassword(String password) {

		InvokeBrowser.driver.findElement(Locators.Pass).sendKeys(password);
		InvokeBrowser.driver.findElement(Locators.Confirm).sendKeys(password);
		InvokeBrowser.driver.findElement(Locators.ResetButton).click();
		String message = Message(Locators.ResetPasswordMessage);
		InvokeBrowser.driver.switchTo().window(tabs.get(0));
		return message;
	}

	public String Message(By locator) {

		return InvokeBrowser.driver.findElement(locator).getText().toString();
	}

	public void DemoWait() throws Throwable {

		Thread.sleep(3000);
	}

}
