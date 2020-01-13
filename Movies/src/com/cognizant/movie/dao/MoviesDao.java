package com.cognizant.movie.dao;

import java.util.List;

import com.cognizant.movie.model.Movies;

public interface MoviesDao {
	public List<Movies> getMoviesListAdmin();

	public List<Movies> getMoviesListCustomer();

	public void modifyMovie(Movies movies);

	public Movies getMovie(Long movieId);
	
}
