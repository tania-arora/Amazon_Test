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

public class ShoppingCartUpdate {
	WebDriver driver;
	WebElement element;
	@Given("Shopping cart should be opened")
	public void shopping_cart_should_be_opened() {
	    // Write code here that turns the phrase above into concrete actions
		driver = new ChromeDriver();
	 driver.get("https://www.amazon.ca/Western-Digital-SA510-Internal-Solid/dp/B09ZYQ84CM/ref=sr_1_6?crid=19ASV8PXXYAAC&dib=eyJ2IjoiMSJ9.949vS87f64zsfRsl6Mj8oWN2tTedODzTvqnsrkIEQD9xmZ2h5uhwX3s0_JZm_POc8UTo3DzXSO3xiQTIBGMb8nrLNok7LcA5MbdiBoaq_LjdzAllzht0F8JaG8449fIOGmmm7ecZEaKSr6F8Ve3RH0_E3443xb2dOMMHNRLKIXJp1WPO1ocTs5B-JgwGUStlwwxmKGqAN8FUoIYPTX1ZOD68K9HSbVyvRE7e3P8-ik4-9j4nJOAJqEyHoYI-sHqtRWZc0dJkxirxcboXKAdYFcwmCNheDLoQ58POFiwhD0M.MfGvKIhjeEq6bo5MALKEeQXhn5djd23iE4CENkn882I&dib_tag=se&keywords=1tb%2Bssd&qid=1710219588&sprefix=%2Caps%2C133&sr=8-6&th=1");
	 driver.manage().window().maximize();

		
	
	}

	@Given("one product is alreay present in the cart")
	public void one_product_is_alreay_present_in_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[2]/div/div[3]/div/div[1]/span/span/a")).click();

	}

	@When("User updates the quantity of the product")
	public void user_updates_the_quantity_of_the_product() {
	    // Write code here that turns the phrase above into concrete actions
		element=driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
	    Select dropdown=new Select(element);
	    dropdown.selectByVisibleText("2");
	}

	@Then("Price should be updated")
	public void price_should_be_updated() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}



}
