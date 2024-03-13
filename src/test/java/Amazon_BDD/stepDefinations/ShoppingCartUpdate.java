package Amazon_BDD.stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ShoppingCartUpdate {
	WebDriver driver;
	WebElement element;
	@Given("Shopping cart should be opened")
	public void shopping_cart_should_be_opened() {
	    // Write code here that turns the phrase above into concrete actions
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.ca/Western-Digital-SA510-Internal-Solid/dp/B09ZYQ84CM/ref=sr_1_6?crid=19ASV8PXXYAAC&dib=eyJ2IjoiMSJ9.949vS87f64zsfRsl6Mj8oWN2tTedODzTvqnsrkIEQD9xmZ2h5uhwX3s0_JZm_POc8UTo3DzXSO3xiQTIBGMb8nrLNok7LcA5MbdiBoaq_LjdzAllzht0F8JaG8449fIOGmmm7ecZEaKSr6F8Ve3RH0_E3443xb2dOMMHNRLKIXJp1WPO1ocTs5B-JgwGUStlwwxmKGqAN8FUoIYPTX1ZOD68K9HSbVyvRE7e3P8-ik4-9j4nJOAJqEyHoYI-sHqtRWZc0dJkxirxcboXKAdYFcwmCNheDLoQ58POFiwhD0M.MfGvKIhjeEq6bo5MALKEeQXhn5djd23iE4CENkn882I&dib_tag=se&keywords=1tb%2Bssd&qid=1710219588&sprefix=%2Caps%2C133&sr=8-6&th=1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	
	}

	@Given("one product is already present in the cart")
	public void one_product_is_already_present_in_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[2]/div/div[3]/div/div[1]/span/span/a")).click();

	}

	@When("User deletes the product from the cart")
	public void user_deletes_the_product_from_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[5]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/div[1]/span[2]/span/input")).click();
	    }

	@Then("Price should be updated to zero")
	public void price_should_be_updated_to_zero()  {
	    // Write code here that turns the phrase above into concrete
		String totalPrice = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[5]/div/div[2]/div[1]/div/form/div[3]/span[2]/span")).getText();
		Assert.assertEquals(totalPrice.replace("$",""),"0.00" );


	}



}
