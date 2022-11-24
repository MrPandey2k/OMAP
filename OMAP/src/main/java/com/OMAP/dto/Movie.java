package com.OMAP.dto;

public class Movie {
	public Movie () {
		
	}
	
	// Instantiate variables for Movie object
	public int movieId;
	public String movieName; // series_title in json
	public String posterLink; // url img to movie poster
	public int year;
	public float imdbRating;
	public String runtime;
	public String director;
	public String starOne;
	public String starTwo;
	public String starThree;
	public String starFour;
	public String overview;
	public String gross;
	public String genre;
	
	// Getters and Setters for Movie object
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getPosterLink() {
		return posterLink;
	}
	public void setPosterLink(String posterLink) {
		this.posterLink = posterLink;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public float getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtine) {
		this.runtime = runtine;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getStarOne() {
		return starOne;
	}
	public void setStarOne(String starOne) {
		this.starOne = starOne;
	}
	public String getStarTwo() {
		return starTwo;
	}
	public void setStarTwo(String starTwo) {
		this.starTwo = starTwo;
	}
	public String getStarThree() {
		return starThree;
	}
	public void setStarThree(String starThree) {
		this.starThree = starThree;
	}
	public String getStarFour() {
		return starFour;
	}
	public void setStarFour(String starFour) {
		this.starFour = starFour;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getGross() {
		return gross;
	}
	public void setGross(String gross) {
		this.gross = gross;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
}