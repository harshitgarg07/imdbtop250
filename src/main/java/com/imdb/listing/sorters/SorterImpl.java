package com.imdb.listing.sorters;

import java.util.LinkedList;

import com.imdb.model.Movie;
import com.imdb.web.pages.SorterName;

/**
 * @author harshitgarg
 *
 */
public final class SorterImpl {

	private ByIMDBRating imdbRating = null;
	private ByRanking ranking = null;
	private ByRelaseDate releaseDate = null;

	public SorterImpl() {
		setImdbRating(new ByIMDBRating());
		setRanking(new ByRanking());
		setReleaseDate(new ByRelaseDate());
	}

	public ByIMDBRating getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(ByIMDBRating imdbRating) {
		this.imdbRating = imdbRating;
	}

	public ByRanking getRanking() {
		return ranking;
	}

	public void setRanking(ByRanking ranking) {
		this.ranking = ranking;
	}

	public ByRelaseDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(ByRelaseDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public LinkedList<Movie> sortBy(LinkedList<Movie> movieList, SorterName sorterName) {
		
		switch (sorterName) {
		case Ranking:
			return getRanking().sortBy(movieList);
		case Rating:
			return getImdbRating().sortBy(movieList);
		case ReleaseDate:
			return getReleaseDate().sortBy(movieList);
		case NumberOfRatings:
			break;
		case YourRating:
			break;
		default:
			break;
		}
		return null;
	}
}