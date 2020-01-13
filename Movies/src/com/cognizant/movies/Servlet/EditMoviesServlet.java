package com.cognizant.movies.Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.MoviesDao;
//import com.cognizant.movie.dao.MoviesDaoCollectionImpl;
import com.cognizant.movie.dao.MoviesDaoSqlImpl;
import com.cognizant.movie.model.Movies;
import com.cognizant.movie.util.DateUtil;

/**
 * Servlet implementation class EditMoviesServlet
 */
@WebServlet("/EditMovies")
public class EditMoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMoviesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		String title = request.getParameter("title");
		Long gross = Long.parseLong(request.getParameter("gross"));
		boolean active = request.getParameter("active").equals("yes");
		Date dateOfLaunch = new DateUtil().convertToDate(request.getParameter("dateOfLaunch"));
		String genre = request.getParameter("genre");
		boolean hasTeaser = request.getParameter("hasTeaser") != null;
		
		Movies movies = new Movies(id,title,gross,active,dateOfLaunch,genre,hasTeaser);
		MoviesDao moviesDao = new MoviesDaoSqlImpl();
		moviesDao.modifyMovie(movies);
		
		request.getRequestDispatcher("edit-movie-status.jsp").forward(request, response);
		doGet(request, response);
	}

}
