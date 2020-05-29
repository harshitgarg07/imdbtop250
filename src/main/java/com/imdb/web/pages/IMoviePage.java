package com.imdb.web.pages;

public interface IMoviePage {
	
	String xpathMovieList = "//tbody[@class='lister-list']/tr";
	String xpathRank = "//td[@class='titleColumn']";
	String xpathTitle = "//td[@class='titleColumn']/a";
	String xpathYear = "//td[@class='titleColumn']/span";
	String xpathRating = "//td[@class='ratingColumn imdbRating']";
	String idDropDown = "lister-sort-by-options";
}
