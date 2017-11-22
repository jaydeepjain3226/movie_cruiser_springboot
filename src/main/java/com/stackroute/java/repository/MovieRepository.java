package com.stackroute.java.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.stackroute.java.domain.Movie;


@Component
public interface MovieRepository extends CrudRepository<Movie, String> {
//private movie
	
	public Movie findById(int id);
}
