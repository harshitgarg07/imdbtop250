package com.imdb.listing.sorters;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import com.imdb.model.Movie;

/**
 * @author harshitgarg
 *
 */
final class ByIMDBRating implements Sorter<Movie> {



	public LinkedList<Movie> sortBy(LinkedList<Movie> movieList) {

		Collections.sort(movieList, new Comparator<Movie>() {

			public int compare(Movie o1, Movie o2) {
				if(o2.getRating()>o1.getRating())
					return 1;
				if(o2.getRating()>o1.getRating())
					return -1;
				return 0;
			}
		});
		return movieList;
	}

}