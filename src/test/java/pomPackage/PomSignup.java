package pomPackage;

import java.util.NoSuchElementException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class PomSignup extends Base {
@FindBy(id="ap_customer_name")
WebElement YourName;

@FindBy (id="ap_email")
WebElement Email_phoneno;

@FindBy (id="ap_password")
WebElement Password;

@FindBy (id="ap_password_check")
WebElement Password_again;

@FindBy(id="continue")
WebElement cont;


String invalidNameErrorXpath ="/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[1]/div/div/div"	;

String AlreadyExistingCustomer="/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[2]/div[5]/div/div";
public PomSignup() {
	PageFactory.initElements(driver,this);		//initElements method is used to initialize the variables declared above
}

public void typeYourName(String name) {
	YourName.sendKeys(name);
}
public void typeEmailId(String email) {
	Email_phoneno.sendKeys(email);
	
}

public void typePassword(String pass) {
	Password.sendKeys(pass);
}

public void typePasswordAgain(String pass) {
	Password_again.sendKeys(pass);
}

public void ClickContinue() {
	cont.click();
}

public boolean isNavigated()
{
	return !driver.getCurrentUrl().equals(prop.getProperty("URL"));
}

public boolean isInvalidNameMessageDisplayed()
{
	try {
		driver.findElement(By.xpath(invalidNameErrorXpath));
		return true;
	} catch(NoSuchElementException e) {
		// TODO: handle exception
		return false;
	}	
}


public boolean isAlreadyExistingCustomerErrorMessageDisplayed() 
{
	try {	
	
	driver.findElement(By.xpath(AlreadyExistingCustomer));
	return true;
		}
	catch (NoSuchElementException e)
		{
	// TODO: handle exception
	return false;
		}
}
}













































