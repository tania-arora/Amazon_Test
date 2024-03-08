package testPackage;

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
		initiation();
		sign_up=new PomSignup();
		
	}
@Test
public void typeYname() {
	sign_up.typeYourName("tania");
}

	
}
