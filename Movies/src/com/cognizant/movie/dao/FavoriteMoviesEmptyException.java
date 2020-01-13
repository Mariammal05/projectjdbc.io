package com.cognizant.movie.dao;

public class FavoriteMoviesEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FavoriteMoviesEmptyException() {
		super("Favorites List is Empty");
	}
	
}
