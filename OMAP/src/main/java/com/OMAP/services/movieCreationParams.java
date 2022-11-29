package com.OMAP.services;

import org.springframework.util.Assert;

public class movieCreationParams {
    private final String movieName;
    private final String runtime;
    private final String starOne;
    private final String genre;

    public movieCreationParams(String movieName, String runtime, String starOne, String genre){
        Assert.notNull(movieName,"Movie Name should not be empty");
        Assert.notNull(runtime,"Movie runtime should not be empty");
        Assert.notNull(starOne,"Lead Actor/Actress Name should not be empty");
        this.movieName = movieName;
        this.runtime = runtime;
        this.starOne = starOne;
        this.genre = genre;
    }
    
    public String getMovieName(){return movieName;}
    public String getRuntime(){return runtime;}
    public String getStarOne(){return starOne;}
    public String getGenre(){return genre;}
}
