package com.cognizant.movies.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.MoviesDao;
//import com.cognizant.movie.dao.MoviesDaoCollectionImpl;
import com.cognizant.movie.dao.MoviesDaoSqlImpl;
import com.cognizant.movie.model.Movies;

/**
 * Servlet implementation class ShowMovieListAdminServlet
 */
@WebServlet("/ShowMovieListAdmin")
public class ShowMovieListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowMovieListAdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		moviesDao.getMoviesListAdmin();
		List<Movies> moviesList = moviesDao.getMoviesListAdmin();
		request.setAttribute("moviesList", moviesList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie-list-admin.jsp");
		dispatcher.forward(request, response);

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
