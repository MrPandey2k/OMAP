package com.OMAP.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
// import org.springframework.data.annotation.Id;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.data.relational.core.mapping.Column;

@Entity
// @Table
public class Movie {
	

	// Instantiate variables for Movie object
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(value = "movieId")
	private long	movieId;
	@NotBlank(message = "Name is mandatory")
	@Column(value = "movieName")
	private String 	movieName; // series_title in json
	@Column(value = "posterLink")
	private String 	posterLink; // url img to movie poster
	private int 		year;
	@Column(value = "imdbRating")
	private float 	imdbRating;
	@NotBlank(message = "Run time is mandatory")
	private String 	runtime;
	private String 	director;
	@NotBlank(message = "Lead Actor/Actress is mandatory")
	@Column(value = "starOne")
	private String 	starOne;
	@Column(value = "starTwo")
	private String 	starTwo;
	@Column(value = "starThree")
	private String 	starThree;
	@Column(value = "starFour")
	private String 	starFour;
	private String 	overview;
	private String 	gross;
	@NotBlank(message = "Genre is mandatory")
	private String 	genre;

	public Movie () {
		
	}
	
	public Movie(String movieName, String runtime, String starOne, String genre) {
		this.movieName = movieName;
		this.runtime = runtime;
		this.starOne = starOne;
		this.genre = genre;
		this.director = "";
		this.starTwo= "";
		this.starThree= "";
		this.starFour= "";
		this.gross= "";
		this.posterLink="";
		this.year = 0;
		this.gross = "0";
		this.imdbRating = 0;
	}
	
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
	public long getMovieId() {
		return  this.movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
}