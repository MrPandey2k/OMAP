package com.OMAP.dao;

// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.OMAP.dto.Movie;


@Repository
public interface ICloudMovieDAO extends JpaRepository<Movie, Long> {
}
