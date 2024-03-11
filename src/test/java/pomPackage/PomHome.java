package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import net.bytebuddy.asm.Advice.Return;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class PomHome extends Base {
	
	@FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
	WebElement searchBox;

	@FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
	WebElement searchButton;

	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/span/div/div/span")
	WebElement results;

	@FindBy(xpath = "//*[@id=\"p_72/11192170011\"]")
	WebElement fourStarFilter;

	@FindBy(xpath = "//*[@id=\"reviewsRefinements\"]/ul/span/li")
	WebElement ratingFilterClearButton;

	@FindBy(xpath = "/html/body/div[1]/div[1]/span[2]/div/h1/div/div[4]/div/div/form/span/select")
	WebElement sortBySelector;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[66]/div/div/span/a[3]")
	WebElement nextButton;


	String resultsXpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/span/div/div/span";
	String searchedStringXpath = "//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[3]";
	
	public PomHome() {
		PageFactory.initElements(driver, this);
	}
	
	public void search(String search) {
		searchBox.sendKeys(search);		
	}

	public void performSearch(){
		searchButton.click();
	}

	/*
	Tests whether "Results" text is visible on the product search results page.
	 */
	public boolean isResultsPageDisplayed()
	{
		try{
		driver.findElement(By.xpath(resultsXpath));
		return true;
		}
		catch (NoSuchElementException e){
			return false;
		}
	}

	public void applyRatingFilter(){
		fourStarFilter.click();
	}

	/*
	Tests the filter by checking if "clear filter" button is visible after filter is applied.
	 */
	public boolean isRatingFilterApplied(){
		try{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			WebElement clearButton = driver.findElement(By.xpath("//*[@id=\"reviewsRefinements\"]/ul/span/li/span/a/span[2]"));
			return true;
		}
		catch (NoSuchElementException e){
			return false;
		}
	}

	/*
	Tests whether searched string is visible on the results page
	 */
	public boolean isSearchedStringVisibleOnResultsPage(String text){
	try{
		WebElement searchText = driver.findElement(By.xpath(searchedStringXpath));
		return searchText.getText().equalsIgnoreCase(text);
	}catch(NoSuchElementException e){
		return false;
	}
	}

	/*
	selects Price low to high filter
	 */
	public void selectLowToHighPriceSort(){
		WebElement element = driver.findElement(By.xpath("//*[@id=\"s-result-sort-select\"]"));
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText("Price: Low to high");}

	/*
	checks if the sorting has been applied by the checking the page URL
	Url contains "ref=sr_st_price-asc-rank" if sorted by price ascending
	 */
	
	public boolean IsResultSortedLowToHighPriceCheckByURL(){
		return driver.getCurrentUrl().contains("ref=sr_st_price-asc-rank");
	}
	
	public void IsNavigatedToNextPage()
	{
		driver.findElement(By.xpath("//a[contains(.,'Next')]")).click();
//		nextButton.click();
	}
	
	public boolean isNextButtonVisible() {
		try{
			driver.findElement(By.xpath("//a[contains(.,'Next')]")).click();
				
			return true;
		}
		catch (NoSuchElementException e) {
			return false;
			// TODO: handle exception
		}
	}


}
