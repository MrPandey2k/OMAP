package com.OMAP.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.OMAP.dao.IMovieDAO;
import com.OMAP.dto.Movie;

@Service
public class MovieService {
	

	@Autowired
	IMovieDAO moviedao;
	
	private List<Movie> movies = new ArrayList<Movie>();
	
	@PostConstruct
	private void loadData() {
		try {
			movies = moviedao.getMovies();
		}
		// Any Exception will be caught and returned to the user in the output
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public Page<Movie> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Movie> list;

        if (movies.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, movies.size());
            list = movies.subList(startItem, toIndex);
        }

        Page<Movie> bookPage
          = new PageImpl<Movie>(list, PageRequest.of(currentPage, pageSize), movies.size());

        return bookPage;
    }
}
