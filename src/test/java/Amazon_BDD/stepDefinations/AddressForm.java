package Amazon_BDD.stepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class AddressForm {
	WebDriver driver;
	public static Properties addresss_prop=new Properties();
	
	@Given("address page should be open")
	public void address_page_should_be_open() {
	    // Write code here that turns the phrase above into concrete actions
		
			try {
				
				FileInputStream file = new FileInputStream("C:\\Users\\vikra\\OneDrive\\Desktop\\Tania\\Java workspace\\AmazonFinalProject\\src\\test\\java\\environmentvariables\\config.properties");
				addresss_prop.load(file);
			
			}
				catch(FileNotFoundException a) {
					a.printStackTrace();
				}
			
			catch(IOException e) {
				e.printStackTrace();
			}
			driver = new ChromeDriver();    	
		    driver.get(addresss_prop.getProperty("URL_Signin"));
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

	@When("fills all the information")
	public void fills_all_the_information() {
	    // Write code here that turns the phrase above into concrete actions
	 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFullName\"]")).sendKeys("Amazon");
	 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]")).sendKeys("437-220-1224");
	 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressLine1\"]")).sendKeys("100 sheppard east avenue");
	 driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressCity\"]")).sendKeys("North York");
	 
	
	 driver.manage().window().maximize();
//	 WebElement state = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[1]/div/div[14]/span/select"));
	 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[1]/div/div[14]/span/select")).click();
	 WebElement dropdown =driver.findElement(By.xpath("//select/option[contains(text(), 'Ontario')]"));
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", dropdown);
//	 dropdown.click();
//	 Select dropdown = new Select(state);
//	 	new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div/ul/li[9]/a")));
//		dropdown.selectByVisibleText("Ontario");
//		state.sendKeys(Keys.TAB);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPostalCode\"]")).sendKeys("L6P 2P7");
		driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFormContainer\"]/div[2]/label/span/span")).click();
		driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();
	
	
	
	
	}

	@When("clicks on add address")
	public void clicks_on_add_address() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("New address should be saved")
	public void new_address_should_be_saved() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
