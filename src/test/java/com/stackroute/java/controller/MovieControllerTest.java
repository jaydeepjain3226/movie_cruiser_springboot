package com.stackroute.java.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.java.App;
import com.stackroute.java.domain.Movie;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
	@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
	public class MovieControllerTest extends TestCase {
	    String movie1;
	    @LocalServerPort
	    private int port;
	    TestRestTemplate restTemplate = new TestRestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    Movie movie;
	    @Before
	    public void setUp() throws Exception {
	        movie = new Movie("1",4, "Pizza hut", "Paul Dawson");
	    }
	    private String createURLWithPort(String uri) {
	        return "http://localhost:" + port + uri;
	    }
	    //
	    // @After
	    // public void tearDown() throws Exception {
	    // }
	    @Test
	    public void testAddMovie() throws Exception {
	        HttpEntity<Movie> entity = new HttpEntity<Movie>(movie, headers);
	        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/v1.0/movieservice/movies"),
	                HttpMethod.POST, entity, String.class);
	        assertNotNull(response);
	        String actual = response.getBody();
	        System.out.println(actual);
	        assertEquals("Done", actual);
	    }
	    @Test
	    public void testGetAllMovies() throws Exception {
	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/v1.0/movieservice/movies"),
	                HttpMethod.GET, entity, String.class);
	        assertNotNull(response);
	    }
	    @Test
	    public void testgetMovieById() throws Exception {
	        HttpEntity<Movie> entity = new HttpEntity<Movie>(movie, headers);
	        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/v1.0/movieservice/movies/1"),
	                HttpMethod.GET, entity, String.class);
	        assertNotNull(response);
	    }
	    // public void testGetAllMovies1() {
	    // fail("Not yet implemented");
	    // }
	    //
	    // public void testAddMovie() {
	    // fail("Not yet implemented");
	    // }
	    // public void testObject() {
	    // fail("Not yet implemented");
	    // }
	    //
	    // public void testGetClass() {
	    // fail("Not yet implemented");
	    // }
	    //
	    // public void testHashCode() {
	    // fail("Not yet implemented");
	    // }
	    //
	    // public void testEquals() {
	    // fail("Not yet implemented");
	    // }
	    //
	    // public void testClone() {
	    // fail("Not yet implemented");
	    // }
	    //
	    // public void testToString() {
	    // fail("Not yet implemented");
	    // }
	    //
	    // public void testNotify() {
	    // fail("Not yet implemented");
	    // }
	    //
	    // public void testNotifyAll() {
	    // fail("Not yet implemented");
	    // }
	    //
	    // public void testWaitLong() {
	    // fail("Not yet implemented");
	    // }
	    //
	    // public void testWaitLongInt() {
	    // fail("Not yet implemented");
	    // }
	    //
	    // public void testWait() {
	    // fail("Not yet implemented");
	    // }
	    //
	    // public void testFinalize() {
	    // fail("Not yet implemented");
	    // }
	}

