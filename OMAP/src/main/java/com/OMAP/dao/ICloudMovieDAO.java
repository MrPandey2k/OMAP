package com.OMAP.dao;

import org.springframework.data.repository.CrudRepository;

import com.OMAP.dto.Movie;


public interface ICloudMovieDAO extends CrudRepository<Movie, Long> {
}
