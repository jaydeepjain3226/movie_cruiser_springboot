package com.stackroute.java.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.springframework.data.mongodb.core.mapping.Document;

@Entity
public class Movie {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private int movieId;
    private String title;
    private String tagline;
    // private String plot;
    // private String status;
    // private String date;
    // private String urlPicture;
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTagline() {
        return tagline;
    }
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
    public Movie(String id,int movieId, String title, String tagline) {
        super();
        this.id=id;
        this.movieId = movieId;
        this.title = title;
        this.tagline = tagline;
    }
    
    public Movie() {
    }
    
}
