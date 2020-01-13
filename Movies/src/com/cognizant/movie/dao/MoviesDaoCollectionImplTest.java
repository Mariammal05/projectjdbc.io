package com.cognizant.movie.dao;

import java.util.List;

import com.cognizant.movie.model.Movies;
import com.cognizant.movie.util.DateUtil;

public class MoviesDaoCollectionImplTest {

	public static void testGetMoviesListAdmin() {
		System.out.println("Movies List for Admin");
		List<Movies> movieList = new MoviesDaoCollectionImpl().getMoviesListAdmin();
		for (Movies movies : movieList) {
			System.out.println(movies);
		}
	}

	public static void testGetMoviesListCustomer() {
		System.out.println("Movies List for Customer");
		List<Movies> movieList = new MoviesDaoCollectionImpl().getMoviesListCustomer();
		for (Movies movies : movieList) {
			System.out.println(movies);
		}
	}

	public static void testModifyMovie() {
		Movies item = new Movies(5L, "Moana", 2787785087L, true, new DateUtil().convertToDate("15/03/2017"),
				"Science Fiction", true);
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		moviesDao.modifyMovie(item);
		System.out.println("*** Modified Movies  List ***");
		testGetMoviesListAdmin();
		Movies modified_item = moviesDao.getMovie(item.getId());
		System.out.println("Modified Movies Details\n " + modified_item);
	}

	public static void main(String[] args) {
		testGetMoviesListAdmin();
		testGetMoviesListCustomer();
		testModifyMovie();
	}

}
