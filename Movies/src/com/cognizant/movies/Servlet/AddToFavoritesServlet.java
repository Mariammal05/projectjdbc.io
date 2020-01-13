package com.cognizant.movies.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.FavoriteMoviesDao;
//import com.cognizant.movie.dao.FavoriteMoviesDaoCollectionImpl;
import com.cognizant.movie.dao.FavoriteMoviesDaoSqlImpl;
import com.cognizant.movie.dao.MoviesDao;
//import com.cognizant.movie.dao.MoviesDaoCollectionImpl;
import com.cognizant.movie.dao.MoviesDaoSqlImpl;
import com.cognizant.movie.model.Movies;

/**
 * Servlet implementation class AddToFavoritesServlet
 */
@WebServlet("/AddToFavorites")
public class AddToFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToFavoritesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		FavoriteMoviesDao favoriteMoviesDao = new FavoriteMoviesDaoSqlImpl();
		long userId = 1l;
		Long moviesId = Long.parseLong(request.getParameter("moviesId"));
		
		
		favoriteMoviesDao.addFavoriteMovies(userId, moviesId);
		
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		// menuItemDao.getMenuItemListCustomer();
		List<Movies> moviesListCustomer = moviesDao.getMoviesListCustomer();
		
		request.setAttribute("moviesList", moviesListCustomer);
		request.setAttribute("addFavoritemoviesStatus", true);
		request.getRequestDispatcher("movie-list-customer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
