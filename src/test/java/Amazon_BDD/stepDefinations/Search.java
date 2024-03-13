package Amazon_BDD.stepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {
WebDriver driver;
String resultsXpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/span/div/div/span";
String searchedStringXpath = "//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[3]";



public static Properties search_prop=new Properties();
		
		@Given("Amazon home page should be open")
		public void amazon_home_page_should_be_open() {
		    // Write code here that turns the phrase above into concrete actions

			try {
				
				FileInputStream file = new FileInputStream("E:\\Amazon_Test\\src\\test\\java\\environmentvariables\\config.properties");
				search_prop.load(file);
			
			}
				catch(FileNotFoundException a) {
					a.printStackTrace();
				}
			
			catch(IOException e) {
				e.printStackTrace();
			}
			driver = new ChromeDriver();
			driver.get(search_prop.getProperty("URL_HOME"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}

		@When("User searches for a product")
		public void user_searches_for_a_product() {
		    // Write code here that turns the phrase above into concrete actions
		    driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Blue pants");
		}

		@When("clicks on search button")
		public void clicks_on_search_button() {
		    // Write code here that turns the phrase above into concrete actions
		    driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		}

		@When("applies a price filter")
		public void applies_a_price_filter() {
		    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.xpath("//*[@id=\"p_36/12035760011\"]/span/a/span")).click();
		}

		@When("sorts the reults by average customer rating")
		public void sorts_the_reults_by_average_customer_rating() {
		    // Write code here that turns the phrase above into concrete actions
		WebElement element=	driver.findElement(By.xpath("//*[@id=\"s-result-sort-select\"]"));
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText("Avg. customer review");}


		@Then("user should be able to the results")
		public void user_should_be_able_to_the_results() {
		    // Write code here that turns the phrase above into concrete actions
				WebElement searchText = driver.findElement(By.xpath(searchedStringXpath));
				Assert.assertEquals(searchText.getText().contains("Blue pants"),true);
			
		}

		@Then("results should be filtered")
		public void results_should_be_filtered() {
		    // Write code here that turns the phrase above into concrete actions
			try{driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			WebElement clearButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[5]/ul[1]/span/li/span/a/span[2]"));
			Assert.assertTrue(true);
			}
			catch (NoSuchElementException e) {
				// TODO: handle exception
			Assert.assertTrue(false);
			}

		}

		@Then("sorted")
		public void sorted() {
		    // Write code here that turns the phrase above into concrete actions
		  Assert.assertTrue(driver.getCurrentUrl().contains("ref=sr_st_review-rank"));
		}


	}


