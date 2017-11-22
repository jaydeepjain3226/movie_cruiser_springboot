package com.stackroute.java.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.java.domain.Movie;
import com.stackroute.java.repository.MovieRepository;

public class MovieServiceImplTest {


private MovieServiceImpl movieServiceImpl;
@Mock
private MovieRepository movieRepository;
@Mock
private Movie movie;
@Before
public void setupMock() {
    MockitoAnnotations.initMocks(this);
    movieServiceImpl=new MovieServiceImpl();
    movieServiceImpl.setMovieRepository(movieRepository);
}
@Test
public void shouldReturnProduct_whenGetProductByIdIsCalled() throws Exception {
    // Arrange
    when(movieRepository.findOne("10")).thenReturn(movie);
    System.out.println(movieRepository.findById(10));
    // Act
    Movie retrievedProduct = movieServiceImpl.findByMovieId("10");
    // Assert
    System.out.println(retrievedProduct);
    assertThat(retrievedProduct, is(equalTo(movie)));

}

@Test
public void shouldReturnProduct_whenSaveProductIsCalled() throws Exception {
    // Arrange
    when(movieRepository.save(movie)).thenReturn(movie);
    // Act
    Movie savedProduct = movieServiceImpl.addMovie(movie);
    // Assert
    assertThat(savedProduct, is(equalTo(movie)));
}

@Test
public void shouldCallDeleteMethodOfProductRepository_whenDeleteProductIsCalled() throws Exception {
    // Arrange
    doNothing().when(movieRepository).delete("1");
    MovieRepository my = Mockito.mock(MovieRepository.class);
    // Act
    movieServiceImpl.deleteMovie("10");
    // Assert
    verify(movieRepository, times(1)).delete("10");
}
}
