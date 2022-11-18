package com.OMAP.dao;
import com.OMAP.dto.Movie;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieDAO implements IMovieDAO {
	
	@Autowired
	NetworkDAO networkDAO;
	
	
	public List<Movie> getMovies() throws Exception {
		List<Movie> allMovies = new ArrayList<Movie>();
		

		String rawJson = networkDAO.request("https://raw.githubusercontent.com/MrPandey2k/OMAP/main/movies.json");
		
		
		JSONArray movies = new JSONArray(rawJson);
		//JSONArray movies = root.getJSONArray("");
		
		
		try {
			for(int i=0; i < movies.length(); i++) 
			{
				// parse JSON
				JSONObject jsonMovie = movies.getJSONObject(i);
				Movie movie = new Movie();
				int movieId = i;
				var  movieName = jsonMovie.get("Series_Title").toString();
				String posterLink = jsonMovie.getString("Poster_Link");
				int year = jsonMovie.getInt("Released_Year");
				float imdbRating = jsonMovie.getInt("IMDB_Rating");
				String runtime = jsonMovie.getString("Runtime");
				String director = jsonMovie.getString("Director");
				String starOne = jsonMovie.getString("Star1");
				String starTwo = jsonMovie.getString("Star2");
				String starThree = jsonMovie.getString("Star3");
				String starFour = jsonMovie.getString("Star4");
				String overview =jsonMovie.getString("Overview");
				String gross = jsonMovie.getString("Gross");
				
				//map fields
				movie.setMovieId(movieId);
				movie.setMovieName(movieName);
				movie.setPosterLink(posterLink);
				movie.setYear(year);
				movie.setImdbRating(imdbRating);
				movie.setRuntine(runtime);
				movie.setDirector(director);
				movie.setStarOne(starOne);
				movie.setStarTwo(starTwo);
				movie.setStarThree(starThree);
				movie.setStarFour(starFour);
				movie.setOverview(overview);
				movie.setGross(gross);
				
				allMovies.add(movie);
				
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return allMovies;

	}
}
