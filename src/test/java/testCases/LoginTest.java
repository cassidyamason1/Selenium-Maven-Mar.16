package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void LoginFailureTest() {
		
		test = report.startTest("LoginFailureTest"); //generates report only for this test
		
		LoginPage login = new LoginPage();
		login.LoginFunction("xyz@gmail.com", "Abc@1234!");
		
		WebElement ErrorMessage = driver.findElement(By.id("msg_box"));
		String ActualMessage = ErrorMessage.getText();
		String ExpectedMessage = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActualMessage, ExpectedMessage); //in place of if else code. Will return true if it equals
		
		report.endTest(test); //ends the report
		}
	@Test
	public void LoginSuccessTest() {

		test = report.startTest("LoginFailureTest");
		
		LoginPage login2 = new LoginPage();
		login2.LoginFunction("cassidyamason@gmail.com","Watermelon#1");
		
		report.endTest(test);
		
	}
	@Test
	@Parameters({"Param1","Param2"})
	public void ParameterizedTest(String UsernameVal, String PasswordVal) {
		
		test = report.startTest("LoginFailureTest");
		
		LoginPage login3 = new LoginPage();
		login3.LoginFunction(UsernameVal, PasswordVal);
		
		report.endTest(test);
	}
	
	@Test
	public void ExternalDataTest() {
		
		test = report.startTest("LoginFailureTest");
		
		String UsernameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue(); 
		
		LoginPage login4 = new LoginPage();
		login4.LoginFunction(UsernameVal, PasswordVal);
		
		report.endTest(test);
	}
		
	}
	

