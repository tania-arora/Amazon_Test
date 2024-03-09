package pomPackage;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class PomSignin extends Base{
	
	@FindBy(id = "ap_email")
	WebElement registeredEmailAddress;
	
	@FindBy(id= "continue")
	WebElement continueButton;
	
	@FindBy(id="ap_password")
	WebElement registeredPassword;
	
	@FindBy (id="signInSubmit")
	WebElement signinButton;
	
	@FindBy(id="/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[2]/div/form/div/div[2]/div/div/label/div/label/span")
	WebElement keepMeSignedIn;
	
	String invalidPasswordMessage="/html/body/div[1]/div[1]/div[2]/div/div[1]/div/div/div";
	
	public PomSignin() {
		PageFactory.initElements(driver, this);
	}

	public void typeEmailAddress(String emailId) {
		registeredEmailAddress.sendKeys(emailId);
	}
	public void clickContinueButton() {
		continueButton.click();
	}
	public void typePassword(String pass) {
		registeredPassword.sendKeys(pass);
	}
	public void clickSignInButton() {
		signinButton.click();
	}
	public boolean isNavigated() {
		System.out.println(driver.getCurrentUrl());
		System.out.println(prop.getProperty("URL_Signin"));
	return	!prop.getProperty("URL_Signin").contains(driver.getCurrentUrl());
		
		
		
	}
	public boolean isInvalidPasswordErrorMessageDisplayed() {
		try {
			driver.findElement(By.xpath(invalidPasswordMessage));
			return true;
		}
		catch (NoSuchElementException e) {
			// TODO: handle exception
		return false;
		}
	}
}
