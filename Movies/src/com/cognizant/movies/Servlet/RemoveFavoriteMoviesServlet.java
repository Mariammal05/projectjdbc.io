package com.cognizant.movies.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.FavoriteMoviesDao;
//import com.cognizant.movie.dao.FavoriteMoviesDaoCollectionImpl;
import com.cognizant.movie.dao.FavoriteMoviesDaoSqlImpl;
import com.cognizant.movie.dao.FavoriteMoviesEmptyException;

/**
 * Servlet implementation class RemoveFavoriteMoviesServlet
 */
@WebServlet("/RemoveFavorites")
public class RemoveFavoriteMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFavoriteMoviesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		long userId = 1l;
		Long movieId = Long.parseLong(request.getParameter("moviesId"));
		FavoriteMoviesDao favoriteMoviesDao = new FavoriteMoviesDaoSqlImpl();
		favoriteMoviesDao.removeFavoriteMovies(userId, movieId);
		try {
			request.setAttribute("favorites", favoriteMoviesDao.getAllFavoriteMovies(userId));
			request.setAttribute("deletefavoritesmoviestatus", true);
			request.getRequestDispatcher("favorites.jsp").forward(request, response);

		} catch (FavoriteMoviesEmptyException e) {
			request.getRequestDispatcher("favorites-empty.jsp").forward(request, response);
		}

	}
		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
