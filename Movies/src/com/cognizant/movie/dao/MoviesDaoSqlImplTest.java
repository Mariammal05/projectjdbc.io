package com.cognizant.movie.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.movie.model.Movies;
import com.cognizant.movie.util.DateUtil;

public class MoviesDaoSqlImplTest {
 
	public static void display(List<Movies>moviesList) {
		DecimalFormat df= new DecimalFormat("##,###");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("\n%25s%25s%25s%25s%25s%25s%25s\n","ID", "TITLE", "GROSS", "	 DATE OF LAUNCH", "ACTIVE", "GENRE",
                 "TEASER");
		  for (Movies movies : moviesList) {
		 String hasTeaser=movies.getHasTeaser() ? "Yes" : "No";	
	        String active = movies.getActive() ? "Yes" : "No";
		System.out.format("\n%25s%25s%25s%25s%25s%25s%25s\n",movies.getId(),movies.getTitle(),'$' +df.format(movies.getGross()),sdf.format(movies.getDateOfLaunch()),
	             active,movies.getGenre(),hasTeaser);
	}
	}
	 public static void testGetMoviesListAdmin() {		 
			
		 ArrayList<Movies> movieListAdmin = new MoviesDaoSqlImpl().getMoviesListAdmin();
		 System.out.println("ADMIN");
		   display(movieListAdmin) ;
		 }
	 public static void testGetMoviesListCustomer() {
		 ArrayList<Movies> movieListCustomer = new MoviesDaoSqlImpl().getMoviesListCustomer();
	     System.out.println("CUSTOMER");
	 display(movieListCustomer);
	 }
	 public static void testGetmodifyMovieListItem() {
		 Movies movies = new  Movies(1L,"TEEN WOLF",2781235087L,true,new DateUtil().convertToDate("15/03/2017"),"Drama",true);
		new MoviesDaoSqlImpl(). modifyMovie(movies);
		
		 testGetMoviesListAdmin();
		 
	 }
	 public static void testGetMovieList() {	
		 long movieId = 1;
		 Movies movies = new MoviesDaoSqlImpl().getMovie(movieId);
		 DecimalFormat df = new DecimalFormat("##,###");
		 SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		 System.out.format("\n%25s%25s%25s%25s%25s%25s%25s\n","ID", "TITLE", "GROSS", "	 DATE OF LAUNCH", "ACTIVE", "GENRE",
                 "	Has Teaser");
		 String hasTeaser=movies.getHasTeaser() ? "yes" : "no";	
	        String active = movies.getActive() ? "yes" : "no";
    System.out.format("\n%25s%25s%25s%25s%25s%25s%25s\n",movies.getId(),movies.getTitle(),"$"+df.format(movies.getGross()),sdf.format(movies.getDateOfLaunch()),
             active,movies.getGenre(),hasTeaser);
		 
	 }
	 public static void main(String args[]) {
		 testGetMoviesListAdmin();
		 testGetMoviesListCustomer();
		 testGetmodifyMovieListItem();
		 testGetMovieList();
	 }
}
