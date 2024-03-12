package Amazon_BDD.stepDefinations;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCart {
	
	WebDriver driver;
	WebElement element;
//	private void checkCaptcha() {
//		try {
//			WebElement capcha = driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/div/div/form/div[1]/div/div/h4"));
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		}catch (NoSuchElementException e) {
//			// TODO: handle exception
//			return;
//		}
	
	
	@Given("product page should be open")
	public void product_page_should_be_open() {
	    // Write code here that turns the phrase above into concrete actions
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		//driver.get("https://www.amazon.ca/");
	  driver.get("https://www.amazon.ca/Western-Digital-SA510-Internal-Solid/dp/B09ZYQ84CM/ref=sr_1_6?crid=19ASV8PXXYAAC&dib=eyJ2IjoiMSJ9.949vS87f64zsfRsl6Mj8oWN2tTedODzTvqnsrkIEQD9xmZ2h5uhwX3s0_JZm_POc8UTo3DzXSO3xiQTIBGMb8nrLNok7LcA5MbdiBoaq_LjdzAllzht0F8JaG8449fIOGmmm7ecZEaKSr6F8Ve3RH0_E3443xb2dOMMHNRLKIXJp1WPO1ocTs5B-JgwGUStlwwxmKGqAN8FUoIYPTX1ZOD68K9HSbVyvRE7e3P8-ik4-9j4nJOAJqEyHoYI-sHqtRWZc0dJkxirxcboXKAdYFcwmCNheDLoQ58POFiwhD0M.MfGvKIhjeEq6bo5MALKEeQXhn5djd23iE4CENkn882I&dib_tag=se&keywords=1tb%2Bssd&qid=1710219588&sprefix=%2Caps%2C133&sr=8-6&th=1");
//driver.manage().window().maximize();	
	  //this.checkCaptcha();
	  
	

}

	@When("User clicks on add to cart")
	public void user_clicks_on_add_to_cart() {
	    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("add-to-cart-button")).click();
	}

	@Then("total cart count should be updated")
	public void total_cart_count_should_be_updated() {
	    // Write code here that turns the phrase above into concrete actions
	 String count= driver.findElement(By.xpath("//*[@id=\"nav-cart-count\"]")).getText();	 
	Assert.assertEquals("1", count);
	driver.close();
	
	}
	

}
