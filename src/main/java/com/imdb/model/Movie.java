package com.imdb.model;

/**
 * @author harshitgarg
 *
 */
public class Movie {

	private int rank;
	private String title;
	private String year;
	private Double rating;
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Movie [rank=" + rank + ", title=" + title + ", year=" + year + ", rating=" + rating + "]";
	}
	
	
}
