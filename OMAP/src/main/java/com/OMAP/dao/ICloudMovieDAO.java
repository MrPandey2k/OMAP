package com.OMAP.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import com.OMAP.dto.Movie;

public interface ICloudMovieDAO extends CrudRepository<Movie, Long> {
    List<Movie> getMovies() throws Exception;
}
