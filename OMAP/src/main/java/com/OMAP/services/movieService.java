package com.OMAP.services;

import com.OMAP.dto.Movie;

public interface movieService {
    Movie createMovie(movieCreationParams params);
    
}
