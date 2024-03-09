package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@FindBy(xpath = "//*[@id=\"s-result-sort-select\"]")
	WebElement sortBySelector;


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

	public boolean isRatingFilterApplied(){
		try{
			WebElement clearButton = driver.findElement(By.xpath("//*[@id=\"reviewsRefinements\"]/ul/span/li"));
			System.out.println(clearButton);
			return true;
		}
		catch (NoSuchElementException e){
			return false;
		}
	}

	public boolean isSearchedStringVisibleOnResultsPage(){
	try{
		driver.findElement(By.xpath(searchedStringXpath));
		return true;
	}catch(NoSuchElementException e){
		return false;
	}
	}

	public void selectLowToHighPriceSort(){
		Select selector = new Select(sortBySelector);
		WebElement element=new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"s-result-sort-select\"]/option[2]")));

		selector.selectByVisibleText("Price: Low to high");
	}


}
