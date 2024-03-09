package testPackage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pomPackage.PomSignin;

public class Signin_test extends Base {
	PomSignin sign_in;
	
	public Signin_test() {
		super();
	}
	@BeforeMethod
	public void initsetup_signin() {
		initiation(prop.getProperty("URL_Signin"));
		sign_in=new PomSignin();
	}
	
	@Test
	public void testSignInValidCredentials() {
		sign_in.typeEmailAddress(prop.getProperty("registeredEmailAddress"));
		sign_in.clickContinueButton();
		sign_in.typePassword(prop.getProperty("registeredPassword"));
		sign_in.clickSignInButton();
		Assert.assertTrue(sign_in.isNavigated());
	}

	@Test
	public void testSigninInvalidCredentials() {
		sign_in.typeEmailAddress(prop.getProperty("registeredEmailAddress"));
		sign_in.clickContinueButton();
		sign_in.typePassword("Test123");
		sign_in.clickSignInButton();
		Assert.assertTrue(sign_in.isInvalidPasswordErrorMessageDisplayed());
		Assert.assertFalse(sign_in.isNavigated());
	
	}

}
