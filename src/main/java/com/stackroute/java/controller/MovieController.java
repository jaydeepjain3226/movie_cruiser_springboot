package com.stackroute.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.java.domain.Movie;
import com.stackroute.java.service.MovieService;


@RestController
@RequestMapping("/v1.0/movieservice")
//@CrossOrigin(origins="*")
public class MovieController {

	@Autowired
	private MovieService movieservice;

	@RequestMapping("/movies")
	public ResponseEntity getAllMovie() {
		List<Movie> resultList1 = movieservice.getAllMovie();
		return new ResponseEntity<List<Movie>>(resultList1, HttpStatus.OK);
	}

	@RequestMapping(value = "/movies", method = RequestMethod.POST, consumes = {"application/json", MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity addMovie(@RequestBody Movie movie) {
		movieservice.addMovie(movie);
		return new ResponseEntity<String>("Done", HttpStatus.OK);
	}

	@RequestMapping(value = "/movies/{id}")
	public ResponseEntity<Movie> getMovieByMovieId(@PathVariable("id") String id) {

		Movie movie = movieservice.findByMovieId(id);
		if (movie == null) {
			return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);

	}

	@RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteMovie(@PathVariable("id") String id) {

		Movie movie = movieservice.findByMovieId(id);
		if (movie == null) {
			return new ResponseEntity<String>("Movie Not Found ", HttpStatus.NOT_FOUND);
		} else {
			movieservice.deleteMovie(id);
			return new ResponseEntity<String>("Deleted Successfully!!!", HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/movies/movieId/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateMovies(@PathVariable("id") String id, @RequestBody Movie movies){
		
		Movie movie = movieservice.findByMovieId(id);
		if (movie == null) {
			return new ResponseEntity<String>("Movie Not Found ", HttpStatus.NOT_FOUND);
		}else {
			movieservice.updateMovies(movies);
			return new ResponseEntity<String>("updated Successfully!!!", HttpStatus.OK);
		}
	}

//	@RequestMapping(value = "/movies/movieId/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<?> updateMovies(@PathVariable("id") String id, @RequestBody Movie movies) {
//
//		Movie currentMovie = movieservice.findByMovieId(id);
//
//		if (currentMovie == null) {
//
//			return new ResponseEntity<String>("id not found", HttpStatus.NOT_FOUND);
//		}
//
//		currentMovie.setMovieId(movies.getMovieId());
//		currentMovie.setTitle(movies.getTitle());
//		currentMovie.setTagline(movies.getTagline());
//
//		movieservice.updateMovies(currentMovie);
//		return new ResponseEntity<Movie>(currentMovie, HttpStatus.OK);
//	}

}
