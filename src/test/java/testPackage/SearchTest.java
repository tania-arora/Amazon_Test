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
		initiation(prop.getProperty("URL_HOME"));
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
		Assert.assertTrue(home.IsResultSortedLowToHighPriceCheckByURL());
	}

	@Test
	public void sortByPriceAscending(){
		String searchKeyWord = "laptop";
		home.search(searchKeyWord);
		home.performSearch();
		home.selectLowToHighPriceSort();
	}

	/*
	This test included:
	searching for keyword "laptop"
	filtering by customer review of 4 or more
	and sorting by price low to high
	 */
	@Test
	public void searchFilterSortTest(){
		String searchKeyWord = "laptop";
		home.search(searchKeyWord);
		home.performSearch();
		Assert.assertFalse(home.isRatingFilterApplied());
		home.applyRatingFilter();
		Assert.assertTrue(home.isRatingFilterApplied());
		home.selectLowToHighPriceSort();
	}

//	@AfterMethod
//	public void closeBrowser(){
//		closeBrower();
//	}

}
