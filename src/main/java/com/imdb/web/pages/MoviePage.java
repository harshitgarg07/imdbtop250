package com.imdb.web.pages;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.imdb.listing.sorters.SorterImpl;
import com.imdb.model.Movie;
import com.imdb.web.base.TestBase;
import com.imdb.web.util.TestUtil;

/**
 * 
 * @author harshitgarg
 *
 */
public class MoviePage extends TestBase implements IMoviePage {

	@FindBy(xpath = xpathMovieList)
	List<WebElement> eleMovieList;
	
	@FindBy(id = idDropDown)
	WebElement dropdown;
	
	WebElement year;
	WebElement rank;
	WebElement rating;
	WebElement title;
	
	LinkedList<Movie> movieList;
	
	public LinkedList<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(LinkedList<Movie> movieList) {
		this.movieList = movieList;
	}

	public LinkedList<Movie> populateMovieList() {
		Movie movie;
		movieList = new LinkedList<Movie>();
		for (WebElement eleMovie : eleMovieList) {
			String movieDetails =eleMovie.getText();
			movie = new Movie();
			String[] details = movieDetails.split(" ");
			movie.setYear(TestUtil.getYear(details[details.length-2]));

			movie.setRank(TestUtil.getRank(details[0]));

			movie.setRating(TestUtil.getRating(details[details.length-1]));

			movie.setTitle(TestUtil.getTitle(details));
			movieList.add(movie);
		}

		return movieList;

	}

	public MoviePage() {
		PageFactory.initElements(driver, this);
	}

	public void sortPage(SorterName sortCriteria) {
		Select dd = new Select(dropdown);
		
		switch (sortCriteria) {
		case Ranking:
			dd.selectByValue("rk:ascending");
			TestUtil.waitUntilPageLoads();
			break;
		case Rating:
			dd.selectByValue("ir:descending");
			TestUtil.waitUntilPageLoads();
			break;
		case ReleaseDate:
			dd.selectByValue("us:descending");
			TestUtil.waitUntilPageLoads();
			break;
		case NumberOfRatings:
			dd.selectByValue("nv:descending");
			TestUtil.waitUntilPageLoads();
			break;
		case YourRating:
			dd.selectByValue("ur:descending");
			TestUtil.waitUntilPageLoads();
			break;
		}
		
	}
	
	public LinkedList<Movie> sortBy(SorterName sorterName) {
		 LinkedList<Movie> sortedList =  new SorterImpl().sortBy(movieList, sorterName);
		 return sortedList;
	}

}