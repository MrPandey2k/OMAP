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

import com.OMAP.dao.IMovieDAO;
import com.OMAP.dto.Movie;

@Controller
public class MoviesController {
	// Instantiate movie object and create new ArrayList to contain them
	@Autowired
	IMovieDAO moviedao;
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
		model.addAttribute("testListMovies", allMovies);
		return "list-movies";
	}

	// Error handling for any other URL
	@GetMapping(value = "/error")
	public String error() {
		return "error";
	}
}