package com.stackroute.java.service;

import java.util.List;

import com.stackroute.java.domain.Movie;

public interface MovieService {
	
	 public List<Movie> getAllMovie();
	 public Movie addMovie(Movie movie);
	 public Movie findByMovieId(String id);
	 public void deleteMovie(String id);
	 public void updateMovies(Movie movie);
	 

}
