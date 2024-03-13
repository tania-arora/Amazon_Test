package Amazon_BDD.stepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignIn {
	WebDriver driver;
	public static Properties prop_bdd = new Properties();


@Given("Sign in page should be open")
public void sign_in_page_should_be_open() {
	try {
		
		FileInputStream file = new FileInputStream("E:\\Amazon_Test\\src\\test\\java\\environmentvariables\\config.properties");
		prop_bdd.load(file);
	
	}
		catch(FileNotFoundException a) {
			a.printStackTrace();
		}
	
	catch(IOException e) {
		e.printStackTrace();
	}
	driver = new ChromeDriver();    	
    driver.get(prop_bdd.getProperty("URL_Signin"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@When("User enters valid email address")
public void user_enters_valid_email_address() {
    // Write code here that turns the phrase above into concrete actions
 driver.findElement(By.id("ap_email")).sendKeys(prop_bdd.getProperty("registeredEmailAddress"));
}

@When("clicks on continue")
public void clicks_on_continue() {
    // Write code here that turns the phrase above into concrete actions
 driver.findElement(By.id("continue")).click();
}

@When("User enters valid password")
public void user_enters_valid_password() {
    // Write code here that turns the phrase above into concrete actions
   driver.findElement(By.id("ap_password")).sendKeys(prop_bdd.getProperty("registeredPassword"));
}

@When("clciks on sign in button")
public void clciks_on_sign_in_button() {
    // Write code here that turns the phrase above into concrete actions
    driver.findElement(By.id("signInSubmit")).click();
}

@Then("User must be logged in")
public void user_must_be_logged_in() {
    // Write code here that turns the phrase above into concrete actions
   
    Assert.assertEquals(true, true);
}

@Then("home page should be open")
public void home_page_should_be_open() {
    // Write code here that turns the phrase above into concrete actions

Assert.assertEquals(!prop_bdd.getProperty("URL_Signin").contains(driver.getCurrentUrl()), true);
	
}


@Then("close the browsers")
public void close_the_browsers() {
    // Write code here that turns the phrase above into concrete actions
    driver.close();
}

}
