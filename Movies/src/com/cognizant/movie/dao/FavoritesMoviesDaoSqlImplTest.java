package com.cognizant.movie.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cognizant.movie.model.Favorites;
import com.cognizant.movie.model.Movies;

public class FavoritesMoviesDaoSqlImplTest {

	private static Scanner scan;
	public static void testaddFavoriteMovies() throws NumberFormatException, IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the User Id to Add");
		long userId=Long.parseLong(bf.readLine());
		System.out.println("Enter the Favorite Id to Add");
			long movieId=Long.parseLong(bf.readLine());
			new FavoriteMoviesDaoSqlImpl().addFavoriteMovies(userId, movieId);
		
	}
	public static void testAllFavoriteMovies() throws FavoriteMoviesEmptyException 
	{
	   scan = new Scanner(System.in);
        System.out.println("Enter the USER ID: ");
        long userId = scan.nextLong();
        Favorites favorites=new FavoriteMoviesDaoSqlImpl().getAllFavoriteMovies(userId);
        double total = favorites.getTotal();
        List<Movies> movie  = favorites.getMovieList();
        DecimalFormat df = new DecimalFormat("##,###");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.format("\n%25s%25s%25s%25s%25s%25s%25s\n","ID", "TITLE", "GROSS", "	 DATE OF LAUNCH", "ACTIVE", "GENRE",
                "	HAS TEASER");
        
        for(Movies movies : movie) {
        String hasTeaser=movies.getHasTeaser() ? "Yes" : "No";	
        String active = movies.getActive() ? "Yes" : "No";
        System.out.format("\n%25s%25s%25s%25s%25s%25s%25s\n",movies.getId(),movies.getTitle(),"$"+df.format(movies.getGross()),sdf.format(movies.getDateOfLaunch()),
                active,movies.getGenre(),hasTeaser);
        	
        }
        System.out.println("Total  ----------->>   "+total);
       
    } 
	


	public static void testremoveFavoriteMovies() throws NumberFormatException, IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the User Id to Delete");
		long userId=Long.parseLong(bf.readLine());
			System.out.println("Enter the Movie Id to Delete");
			long movieId=Long.parseLong(bf.readLine());
			new FavoriteMoviesDaoSqlImpl().removeFavoriteMovies(userId, movieId);
		
	}

	public static void main(String args[]) throws IOException, ParseException, FavoriteMoviesEmptyException  {
		testaddFavoriteMovies();
		testAllFavoriteMovies();
		testremoveFavoriteMovies();
		}

}
