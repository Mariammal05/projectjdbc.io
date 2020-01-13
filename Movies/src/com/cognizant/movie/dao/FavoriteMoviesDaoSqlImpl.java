package com.cognizant.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.movie.model.Favorites;
import com.cognizant.movie.model.Movies;

public class FavoriteMoviesDaoSqlImpl implements FavoriteMoviesDao {
	public static final String ADD_MOVIES_TO_FAVORITES = "INSERT INTO `movie`.`favorites` (`fav_us_id`, `fav_mov_id`) VALUES (?,?);";

	public void addFavoriteMovies(long UserId, long MovieId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(ADD_MOVIES_TO_FAVORITES);
			statement.setLong(1, UserId);
			statement.setLong(2, MovieId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number of Rows Affected -> " + noOfRows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("Unable to connect with database");
			}
		}

	}

	public static final String GET_FAVORITES_MOVIES = "select * from movie_list inner join favorites on favorites.fav_mov_id=movie_list.mov_id inner join user on user.us_id =favorites.fav_us_id where user.us_id=?";
	public static final String GET_TOTAL_FAVORITES = "select count(*) as no_of_favorites from movie.favorites \r\n" + 
			"inner join movie.movie_list  on  mov_id = fav_mov_id\r\n" + 
			"where  fav_us_id=?";
//public static final String GET_ALL_FAVORITES="select*from movie_list inner join favorites on fav_mov_id=mov_id where fav_us_id=?;";
	//public static final String NO_OF_FAVORITES="select count(fav_id) as no_of_favorites from movie.movie_list inner join movie.favorites where fav_mov_id=mov_id and fav_us_id=?"; 
	 

	public Favorites getAllFavoriteMovies(long userId) throws FavoriteMoviesEmptyException {

		ArrayList<Movies> moviesList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementTotal = null;
		ResultSet resultset = null;
		ResultSet resultSetTotal = null;
		Movies movies = null;
		Favorites favorites = new Favorites();
		try {
			preparedStatement = connection.prepareStatement(GET_FAVORITES_MOVIES);
			preparedStatement.setLong(1, userId);
			resultset = preparedStatement.executeQuery();
			

			while (resultset.next()) {

				movies = new Movies();
				movies.setId(resultset.getLong("mov_id"));
				movies.setTitle(resultset.getString("mov_title"));
				movies.setGross(resultset.getLong("mov_gross"));
				movies.setActive(resultset.getString("mov_active").equals("Yes"));
				movies.setDateOfLaunch(resultset.getDate("mov_date_of_launch"));
				movies.setGenre(resultset.getString("mov_genre"));
				movies.setHasTeaser(resultset.getString("mov_teaser").equals("No"));
				moviesList.add(movies);
			}
			if (moviesList.size() == 0) {
				throw new FavoriteMoviesEmptyException();
			}
			favorites.setMovieList(moviesList);
			preparedStatementTotal = connection.prepareStatement(GET_TOTAL_FAVORITES);
			preparedStatementTotal.setLong(1, userId);
			resultSetTotal = preparedStatementTotal.executeQuery();
			Long total = 0L;
			while (resultSetTotal.next()) {
				total = resultSetTotal.getLong("no_of_favorites");
			}
			favorites.setTotal(total);
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
		return favorites;

	}

	public static final String DELETE_MOVIES_TO_FAVORITES = "delete from movie.favorites where fav_us_id=? and fav_mov_id=? limit 1;";

	public void removeFavoriteMovies(long userId, long movieid) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(DELETE_MOVIES_TO_FAVORITES);
			statement.setLong(1, userId);
			statement.setLong(2, movieid);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number of Rows Affected -> " + noOfRows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("Unable to connect with database");
			}
		}

	}

}
