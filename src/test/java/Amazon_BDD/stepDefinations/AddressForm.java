package Amazon_BDD.stepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddressForm {
	WebDriver driver;
	public static Properties addresss_prop=new Properties();
	
	@Given("address page should be open")
	public void address_page_should_be_open() {
	    // Write code here that turns the phrase above into concrete actions
		
			try {
				
				FileInputStream file = new FileInputStream("E:\\Amazon_Test\\src\\test\\java\\environmentvariables\\config.properties");
				addresss_prop.load(file);
			
			}
				catch(FileNotFoundException a) {
					a.printStackTrace();
				}
			
			catch(IOException e) {
				e.printStackTrace();
			}
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		    driver.get(addresss_prop.getProperty("URL_Signin"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.findElement(By.id("ap_email")).sendKeys(addresss_prop.getProperty("registeredEmailAddress"));
		    driver.findElement(By.id("continue")).click();
		    driver.findElement(By.id("ap_password")).sendKeys(addresss_prop.getProperty("registeredPassword"));
		    driver.findElement(By.id("signInSubmit")).click();
		    Actions act= new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"))).build().perform();
			driver.findElement(By.partialLinkText("Your Acc")).click();
			driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/h2")).click();
		}
	
	

	@When("User cicks on add address")
	public void user_cicks_on_add_address() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"ya-myab-address-add-link\"]/div/div")).click();

	}

	@When("fills all the information except State")
	public void fills_all_the_information_except_State() {
	    // Write code here that turns the phrase above into concrete actions
	 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFullName\"]")).sendKeys("Amazon");
	 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]")).sendKeys("437-220-1224");
	 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressLine1\"]")).sendKeys("100 sheppard east avenue");
	 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressCity\"]")).sendKeys("North York");
	 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPostalCode\"]")).sendKeys("L6P 2P7");
	 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFormContainer\"]/div[2]/label/span/span")).click();
	}

	@When("clicks on add address")
	public void clicks_on_add_address() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();
	}

	@Then("Error message should be displayed")
	public void error_message_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
			try{
				WebElement error = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[1]/div/div[14]/div[2]/div/div/div/div"));
				Assert.assertTrue(error.isDisplayed());
			}catch (NoSuchElementException e){
				Assert.assertTrue(false);
			}
	}

}
