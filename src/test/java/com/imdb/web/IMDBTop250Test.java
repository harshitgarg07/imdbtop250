package com.imdb.web;

import java.util.LinkedList;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imdb.listeners.TestListener;
import com.imdb.model.Movie;
import com.imdb.web.base.TestBase;
import com.imdb.web.pages.MoviePage;
import com.imdb.web.pages.SorterName;
import com.imdb.web.util.TestUtil;

/**
 * 
 * @author harshitgarg
 *
 */
@Listeners(TestListener.class)
public class IMDBTop250Test extends TestBase {
	TestUtil testUtil;
	MoviePage moviePage;
	Gson gson;

	public IMDBTop250Test() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeSuite
	public void setUp() {
		setURL();
		initialization();
		testUtil = new TestUtil();
		moviePage = new MoviePage();
		gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	@Test
	public void verifySortingByReleaseDate() {
		
		moviePage.sortPage(SorterName.ReleaseDate);
		LinkedList<Movie> list = moviePage.populateMovieList();
		LinkedList<Movie> actualList = new LinkedList<Movie>(list) ;
		System.out.println(actualList);
		moviePage.sortBy(SorterName.ReleaseDate);
		System.out.println(list);
		Assert.assertTrue(actualList.equals(list));
	}
	
	@Test
	public void verifySortingByRanking() {
		
		moviePage.sortPage(SorterName.Ranking);
		LinkedList<Movie> list = moviePage.populateMovieList();
		LinkedList<Movie> actualList = new LinkedList<Movie>(list) ;
		System.out.println(actualList);
		moviePage.sortBy(SorterName.Ranking);
		System.out.println(list);
		Assert.assertTrue(actualList.equals(list));
	}

	
	@Test
	public void verifySortingByRating() {
		
		moviePage.sortPage(SorterName.Rating);
		LinkedList<Movie> list = moviePage.populateMovieList();
		LinkedList<Movie> actualList = new LinkedList<Movie>(list) ;
		System.out.println(actualList);
		moviePage.sortBy(SorterName.Rating);
		System.out.println(list);
		Assert.assertTrue(actualList.equals(list));
	}
	
	@Test
	public void verifySortingByRatingIsNotEqualToReleaseDate() {
		
		moviePage.sortPage(SorterName.Rating);
		LinkedList<Movie> list = moviePage.populateMovieList();
		LinkedList<Movie> actualList = new LinkedList<Movie>(list) ;
		System.out.println(actualList);
		moviePage.sortBy(SorterName.ReleaseDate);
		System.out.println(list);
		Assert.assertFalse(actualList.equals(list));
	}


	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
