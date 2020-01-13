package com.cognizant.movie.dao;

import com.cognizant.movie.model.Favorites;

public interface FavoriteMoviesDao {
	
	public void addFavoriteMovies(long UserId, long MovieId);

	public Favorites getAllFavoriteMovies(long userId) throws FavoriteMoviesEmptyException;

	public void removeFavoriteMovies(long userId, long movieid);
	
}
