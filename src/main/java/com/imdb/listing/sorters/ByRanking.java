package com.imdb.listing.sorters;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import com.imdb.model.Movie;

/**
 * @author harshitgarg
 *
 */
final class ByRanking implements Sorter<Movie> {



	public LinkedList<Movie> sortBy(LinkedList<Movie> movieList) {

		Collections.sort(movieList, new Comparator<Movie>() {

			public int compare(Movie o1, Movie o2) {
				return o1.getRank() - o2.getRank();
					
			}
		});
		return movieList;
	}

}