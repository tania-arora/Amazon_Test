package testPackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import base.Base;
import pomPackage.PomHome;

public class SearchTest extends Base {
	
	PomHome home;
	public SearchTest() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiation();
		home=new PomHome();
	}
	
	@Test
	public void search() {
		String searchKeyWord = "laptop";
		home.search(searchKeyWord);
		//Results page shouldn't be displayed at this point
		Assert.assertFalse(home.isResultsPageDisplayed()); //false
		home.performSearch();
		//Results page should be displayed
		Assert.assertTrue(home.isResultsPageDisplayed()); //true
		Assert.assertTrue(home.isSearchedStringVisibleOnResultsPage());
	}

	@Test
	public void applyFilter(){
		String searchKeyWord = "laptop";
		home.search(searchKeyWord);
		home.performSearch();
		Assert.assertFalse(home.isRatingFilterApplied());
		home.applyRatingFilter();
		Assert.assertTrue(home.isRatingFilterApplied());
	}

	@Test
	public void sortByPriceAscending(){
		String searchKeyWord = "laptop";
		home.search(searchKeyWord);
		home.performSearch();
//		home.selectLowToHighPriceSort();
	}

	@AfterMethod
	public void closeBrowser(){
		closeBrower();
	}

}
