package com.OMAP.dto;

import com.OMAP.services.movieCreationParams;

import javax.validation.constraints.NotBlank;

public class createMovieFormData {
    @NotBlank(message = "Name is mandatory")
	private String 	movieName;
    @NotBlank(message = "Run time is mandatory")
	private String 	runtime;
    @NotBlank(message = "Lead Actor/Actress is mandatory")
	private String 	starOne;
    @NotBlank(message = "Genre is mandatory")
	private String 	genre;

    public String getMovieName(){return movieName;}
    public String getRuntime(){return runtime;}
    public String getStarOne(){return starOne;}
    public String getGenre(){return genre;}
    public void setMovieName(String movieNameString){ movieName = movieNameString;}
    public void setRuntime  (String runtimeString){ runtime = runtimeString;}
    public void setStarOne  (String starOneString){starOne = starOneString;}
    public void setGenre    (String genreString){ genre = genreString;}

    public movieCreationParams toParameters(){
        return new movieCreationParams(movieName, runtime, starOne, genre);
    }
}
