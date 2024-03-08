package pomPackage;

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

}
