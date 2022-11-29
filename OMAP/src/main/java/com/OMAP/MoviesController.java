package com.OMAP;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.OMAP.dao.ICloudMovieDAO;
import com.OMAP.dao.IMovieDAO;
import com.OMAP.dto.Movie;

@Controller
public class MoviesController {
	// Instantiate movie object and create new ArrayList to contain them
	@Autowired
	IMovieDAO moviedao;
	List<Movie> allMovies = new ArrayList<Movie>();
	List<Movie> testMovies = new ArrayList<Movie>();
	List<Movie> favMovies = new ArrayList<Movie>();

	@Autowired
	ICloudMovieDAO cloudMovieRepo;
	List<Movie> cloudAllMovies = new ArrayList<Movie>();
	List<Movie> cloudTestMovies = new ArrayList<Movie>();
	List<Movie> cloudFavMovies = new ArrayList<Movie>();

	// int number = 46;

	// Create movie objects from JSON data
	@PostConstruct
	private void loadData() {
		try {
			allMovies = moviedao.getMovies();
			cloudAllMovies = (List<Movie>) cloudMovieRepo.findAll();

		}
		// Any Exception will be caught and returned to the user in the output
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Mapping for localhost:8080/ (Redirects to /list)
	@RequestMapping(value = "/")
	public String index() {
		return "redirect:/list";
	}

	// Mapping for localhost:8080/movie-details
	@RequestMapping("/movie-details")
	public String movieDetails(@RequestParam(name="id", required=true) int id, Model model) {
		// Select movie from "id" param in URL
		Movie selectedMovie = allMovies.get(id);
		
		// Add content to /movie-details page
		model.addAttribute("selectedMovie",selectedMovie);

		return "movie-details";
	}
	
	// Mapping for localhost:8080/list
	@GetMapping("/list")
	public String list(Model model) {
		// Select all movies and add content to /list page
		model.addAttribute("ListMovies", cloudAllMovies);
		return "list-movies";
	}
	@GetMapping("/favorite")
	public String favorite(@RequestParam(name="id", required=true) int id, Model model) {
		Movie selectedMovie = allMovies.get(id);
		boolean contains = favMovies.contains(selectedMovie);
		if(contains) {
			// is present in the list
		} else {
			// is not present in the list
			favMovies.add(selectedMovie);
		}
			
		model.addAttribute("ListMovies", favMovies);
		return "favorite";
	}
	@GetMapping("/favorite-list")
	public String favorite(Model model) {
		model.addAttribute("ListMovies", favMovies);
		return "favorite";
	}
	// Error handling for any other URL
	@GetMapping("/error")
	public String error() {
		return "error";
	}
}