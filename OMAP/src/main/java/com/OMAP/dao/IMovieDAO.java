package com.OMAP.dao;

import java.util.List;
import com.OMAP.dto.Movie;

public interface IMovieDAO {
	// Append all movies to a List
	List<Movie> getMovies() throws Exception;
}
