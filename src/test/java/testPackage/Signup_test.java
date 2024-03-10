package testPackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pomPackage.PomSignup;

public class Signup_test extends Base{
	PomSignup sign_up;
	public Signup_test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation(prop.getProperty("URL"));
		sign_up=new PomSignup();
		
	}
@Test
public void SignUp_ValidData() {
	sign_up.typeYourName(prop.getProperty("YourName"));
	sign_up.typeEmailId(prop.getProperty("EmailId"));
	sign_up.typePassword(prop.getProperty("Password"));
	sign_up.typePasswordAgain(prop.getProperty("PasswordAgain"));
	sign_up.ClickContinue();
	Assert.assertTrue(sign_up.isNavigated());
	
}

@Test
public void SignUp_InvalidData() {
	sign_up.typeYourName("");
	sign_up.typeEmailId(prop.getProperty("EmailId"));
	sign_up.typePassword(prop.getProperty("Password"));
	sign_up.typePasswordAgain(prop.getProperty("PasswordAgain"));
	sign_up.ClickContinue();
	Assert.assertFalse(sign_up.isNavigated());
	Assert.assertTrue(sign_up.isInvalidNameMessageDisplayed());
}

@Test
public void SignUp_duplicateEMailAddress() {
	sign_up.typeYourName(prop.getProperty("YourName"));
	sign_up.typeEmailId("tania786arora@gmail.com");
	sign_up.typePassword(prop.getProperty("Password"));
	sign_up.typePasswordAgain(prop.getProperty("PasswordAgain"));
	sign_up.ClickContinue();
	Assert.assertTrue(sign_up.isAlreadyExistingCustomerErrorMessageDisplayed());
	
}


@AfterMethod
public void closeBrowser(){
	closeBrower();
}


}