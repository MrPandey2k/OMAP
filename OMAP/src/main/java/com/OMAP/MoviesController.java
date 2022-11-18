package com.OMAP;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.OMAP.dao.IMovieDAO;
import com.OMAP.dto.Movie;

@Controller
public class MoviesController {
	
	@Autowired
	IMovieDAO moviedao;
	List<Movie> allMovies = new ArrayList<Movie>();
	List<Movie> testMovies = new ArrayList<Movie>();
	int number = 46;
	
	@PostConstruct
	private void loadData() {
		try {
			allMovies = moviedao.getMovies();
			testMovies = allMovies.subList(63, 70); // filtering the array for these elements just to test display
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/list")
	public String list(Model model) {

		model.addAttribute("testListMovies", testMovies);
		
		return "list-movies";		
	}
}
