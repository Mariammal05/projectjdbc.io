package com.cognizant.movie.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.movie.model.Movies;
import com.cognizant.movie.util.DateUtil;

public class MoviesDaoCollectionImpl implements MoviesDao {
	private static List<Movies> movieList;

	public MoviesDaoCollectionImpl() {
		if (movieList == null) {
			movieList = new ArrayList<Movies>();
			Movies itemOne = new Movies(1L, "Avatar", 2787965087l, true, new DateUtil().convertToDate("15/03/2017"),
					"Science Fiction", true);
			Movies itemTwo = new Movies(2L, "The Avengers",1510812988l, true, new DateUtil().convertToDate("23/03/2022"),
					"Superhero", true);
			Movies itemThree = new Movies(3L, "Titanic", 2187463944l, true, new DateUtil().convertToDate("21/08/2018"),
					"Romance", true);
			Movies itemFour = new Movies(4L, "Jurassic World", 1671713208l, false, new DateUtil().convertToDate("12/12/2019"), "Science Fiction", true);
			Movies itemFive = new Movies(5L, "Avengers:End Game", 2750760348l, true,new DateUtil().convertToDate("02/12/2020"), "Superhero", true);
			movieList.add(itemOne);
			movieList.add(itemTwo);
			movieList.add(itemThree);
			movieList.add(itemFour);
			movieList.add(itemFive);

		}
	}

	public List<Movies> getMoviesListAdmin() {
		return movieList;
	}

	public List<Movies> getMoviesListCustomer() {
		ArrayList<Movies> filteredMovie = new ArrayList<Movies>();
		for (Movies movies : movieList) {
			if (movies.getDateOfLaunch().after(new Date())) {
				if (movies.getActive()) {
					filteredMovie.add(movies);
				}
			}
		}
		return filteredMovie;
	}

	public void modifyMovie(Movies movies) {
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movies.getId()) {
				movieList.set(i, movies);
			}
		}
	}

	public Movies getMovie(Long movieId) {
		for (Movies movies : movieList) {
			if (movies.getId() == movieId) {
				return movies;
			}
		}
		return null;
	}
	
}
