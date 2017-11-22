package com.stackroute.java.service;

import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.java.domain.Movie;
import com.stackroute.java.repository.MovieRepository;



@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;
	
    public MovieRepository getMovieRepository() {
		return movieRepository;
	}
    @Autowired
	public void setMovieRepository(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}




	static List<Movie> resultList = new ArrayList<>(
            Arrays.asList(new Movie("1", 42, "social", "sddasc"), 
            		       new Movie("2", 44, "ascl", "sddefsc"), 
            		       new Movie("3", 45, "sacvha", "sac")));
    
    
    public List<Movie> getAllMovie() {
    	
    	List<Movie> movieList = (List<Movie>) movieRepository.findAll();
    	return movieList;
    }
    // public Restaurant getRestaurant(String id)
    // {
    // return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
    // }
    /*public void addMovie(Movie movie) {
        resultList.add(movie);
    }*/ 
    
    public Movie addMovie(Movie movie) {
    	movieRepository.save(movie);
    	return movie;
    }
    
    public Movie findByMovieId(String id) {
    	if(movieRepository.findOne(id)==null)
    		return null;
    	else
        return movieRepository.findOne(id);
        
    }
    
/*    public static Movie findById(int id) {
        for (Movie movie:resultList) {
            if (movie.getId()==id)
                return movie;
        }
        return null;
    }*/
    
/*    public void deleteMovie(int id) {
        for (Movie movie:resultList) {
            if (movie.getId()==id)
                resultList.remove(movie);
        }
    
    }*/
    
  public void deleteMovie(String id) {
		movieRepository.delete(id);

    
  }
    
    public void updateMovies(Movie movie) {
    	 movieRepository.save(movie);
    	
    }
}
