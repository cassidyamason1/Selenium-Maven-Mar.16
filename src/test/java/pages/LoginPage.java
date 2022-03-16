package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testCases.BaseClass;

public class LoginPage {

	WebDriver driver = BaseClass.driver;
	ExtentTest test = BaseClass.test;
	
	//===================== Web Elements ================================
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	
	@FindBy(name = "user_login")
	WebElement UserName;
	
	@FindBy(name = "user_pwd")
	WebElement Password;
	
	@FindBy(name = "btn_login")
	WebElement loginButton;
	
	@FindBy(className = "rememberMe")
	WebElement RememberMe;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this); //identify which driver to create the locators
	}
	
	//==================== Functions ======================================
	
	public void LoginFunction(String UsernameVal, String PasswordVal) {
		         
		LoginLink.click();
		test.log(LogStatus.PASS, "Click on the Login Link", "Login link clicked successfully");
		UserName.sendKeys(UsernameVal);
		test.log(LogStatus.PASS, "Enter user name", "Username entered successfully");
		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Enter password", "Password entered successfully");
		RememberMe.click();
		test.log(LogStatus.PASS, "Click on the Remember Me Link", "Remember me clicked successfully");
		loginButton.click();
		test.log(LogStatus.PASS, "Click on the Login button", "Login button clicked successfully");
	}
	
	public void UICheck() {
		
		Assert.assertTrue(UserName.isDisplayed());
	}
}
