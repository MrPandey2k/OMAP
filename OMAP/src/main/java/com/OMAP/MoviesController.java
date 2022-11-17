package com.OMAP;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.OMAP.dao.IMovieDAO;
import com.OMAP.dto.Movie;
import com.OMAP.service.MovieService;

@Controller
public class MoviesController {
	// Instantiate movie object and create new ArrayList to contain them
	@Autowired
	IMovieDAO moviedao;
	@Autowired
    MovieService movieService;
    
	List<Movie> allMovies = new ArrayList<Movie>();
	List<Movie> testMovies = new ArrayList<Movie>();
	int number = 46;

	// Create movie objects from JSON data
	@PostConstruct
	private void loadData() {
		try {
			allMovies = moviedao.getMovies();
			testMovies = allMovies.subList(63, 70); // filtering the array for these elements just to test display
		}
		// Any Exception will be caught and returned to the user in the output
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Mapping for localhost:8080/
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping("/movie-details")
	public String movieDetails(@RequestParam(name="id", required=true) int id, Model model) {
		Movie selectedMovie = allMovies.get(id);
		model.addAttribute("selectedMovie",selectedMovie);
		return "movie-details";
	}
	
	// Mapping for localhost:8080/list
	@GetMapping("/list")
	public String list(Model model) {
	//public String list(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		
		model.addAttribute("testListMovies", allMovies);
		
		//adding pagination to the list table
		// using this guide to attempt paginator
		// https://www.baeldung.com/spring-thymeleaf-pagination
		/*
		int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Movie> moviePage = movieService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("bookPage", moviePage);

        int totalPages = moviePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
		*/
		return "list-movies";
	}

	// Error handling for any other URL
	@GetMapping(value = "/error")
	public String error() {
		return "error";
	}
}