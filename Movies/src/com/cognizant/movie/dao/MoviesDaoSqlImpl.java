package com.cognizant.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.movie.model.Movies;
import com.cognizant.movie.util.DateUtil;

public class MoviesDaoSqlImpl implements MoviesDao {

	public static final String GET_ALL_MOVIE_LIST_ADMIN = "SELECT * FROM movie.movie_list; ";
	public static final String GET_ALL_MOVIE_LIST_CUSTOMER = "Select * from movie_list where mov_date_of_launch > curdate() and mov_active = 'Yes' ;\r\n"
			+ "";
	public static final String MODIFY_MOVIE_LIST_ITEM = "update movie.movie_list set mov_title=?,mov_gross=?,mov_active=?,mov_date_of_launch=?,mov_genre=?,mov_teaser=? where mov_id=?";
	public static final String GET_MOVIES_LIST = "SELECT * FROM movie.movie_list where mov_id = ?;";

	public ArrayList<Movies> getMoviesListAdmin() {
		ArrayList<Movies> movieList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_MOVIE_LIST_ADMIN);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mov_id"));
				movies.setTitle(resultSet.getString("mov_title"));
				movies.setGross(resultSet.getLong("mov_gross"));
				movies.setDateOfLaunch(resultSet.getDate("mov_date_of_launch"));
				movies.setActive(resultSet.getString("mov_active").equals("Yes"));
				movies.setGenre(resultSet.getString("mov_genre"));
				movies.setHasTeaser((resultSet).getString("mov_teaser").equals("Yes"));
				movieList.add(movies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
			}
		}
		return movieList;
	}

	public ArrayList<Movies> getMoviesListCustomer() {
		ArrayList<Movies> movieList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_MOVIE_LIST_CUSTOMER);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mov_id"));
				movies.setTitle(resultSet.getString("mov_title"));
				movies.setGross(resultSet.getLong("mov_gross"));
				movies.setDateOfLaunch(resultSet.getDate("mov_date_of_launch"));
				movies.setActive(resultSet.getString("mov_active").equals("Yes"));
				movies.setGenre(resultSet.getString("mov_genre"));
				movies.setHasTeaser((resultSet).getString("mov_teaser").equals("Yes"));
				movieList.add(movies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
			}
		}
		return movieList;
	}

	public void modifyMovie(Movies movies) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(MODIFY_MOVIE_LIST_ITEM);
			preparedStatement.setString(1, movies.getTitle());
			preparedStatement.setFloat(2, movies.getGross());
			preparedStatement.setString(3, movies.getActive() ? "Yes" : "No");
			preparedStatement.setDate(4, new DateUtil().convertToSqlDate(movies.getDateOfLaunch()));
			preparedStatement.setString(5, movies.getGenre());
			preparedStatement.setString(6, movies.getHasTeaser() ? "Yes" : "No");
			// preparedStatement.setString(6,menuItem.getFreeDelivery()?"yes":"no");
			preparedStatement.setLong(7, movies.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	public Movies getMovie(Long movieId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		Movies movies = null;
		try {
			preparedStatement = connection.prepareStatement(GET_MOVIES_LIST);
			preparedStatement.setLong(1, movieId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				movies = new Movies();
				movies.setId(resultSet.getLong("mov_id"));
				movies.setTitle(resultSet.getString("mov_Title"));
				movies.setGross(resultSet.getLong("mov_Gross"));
				movies.setDateOfLaunch(resultSet.getDate("mov_date_of_launch"));
				movies.setActive(resultSet.getString("mov_active").equals("Yes"));
				movies.setGenre(resultSet.getString("mov_genre"));
				movies.setHasTeaser((resultSet).getString("mov_teaser").equals("Yes"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null) {
					resultset.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
			}
		}
		return movies;
	}
}
