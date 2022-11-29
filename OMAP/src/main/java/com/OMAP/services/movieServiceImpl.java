package com.OMAP.services;

import org.springframework.stereotype.Service;

import com.OMAP.dao.ICloudMovieDAO;
import com.OMAP.dto.Movie;

@Service
public class movieServiceImpl implements movieService {
    private final ICloudMovieDAO repository;

    public movieServiceImpl(ICloudMovieDAO repository){
        this.repository = repository;
    }

    public Movie createMovie(movieCreationParams params){
        Movie movie = new Movie(params.getMovieName(),params.getRuntime(),params.getStarOne(), params.getGenre());
        return repository.save(movie);
    }
}
