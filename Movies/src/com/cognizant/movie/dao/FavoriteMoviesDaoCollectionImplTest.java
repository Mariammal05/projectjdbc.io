package com.cognizant.movie.dao;

import com.cognizant.movie.model.Favorites;
import com.cognizant.movie.model.Movies;

public class FavoriteMoviesDaoCollectionImplTest {
	public static void testAddFavorites() throws FavoriteMoviesEmptyException {

		FavoriteMoviesDao favoriteMoviesDao = new FavoriteMoviesDaoCollectionImpl();
		favoriteMoviesDao.addFavoriteMovies(1, 3L);
		favoriteMoviesDao.addFavoriteMovies(1, 5L);
		favoriteMoviesDao.addFavoriteMovies(1, 2L);

		System.out.println("User Added Favorite List for Checkout");
		Favorites favorite = favoriteMoviesDao.getAllFavoriteMovies(1);
		for (Movies moviesList : favorite.getMovieList()) {
			System.out.println(moviesList);
		}
		System.out.println("No.of.Favorites:" + favorite.getMovieList().size());
	}

	public static void testRemoveFavoriteMovies() {
		FavoriteMoviesDao favoritesDao = new FavoriteMoviesDaoCollectionImpl();
		System.out.println("Movie List for Customer after Remove");
		try {

			favoritesDao.removeFavoriteMovies(1, 3L);
			favoritesDao.removeFavoriteMovies(1, 5L);

			Favorites favorites = favoritesDao.getAllFavoriteMovies(1);

			for (Movies movies : favorites.getMovieList()) {
				System.out.println(movies);
			}
			System.out.println("No.of.Favorites:" + favorites.getMovieList().size());
		} catch (FavoriteMoviesEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testGetAllFavoriteItems() {

	}

	public static void main(String[] args) throws FavoriteMoviesEmptyException {
		testAddFavorites();
		testRemoveFavoriteMovies();

	}

}
