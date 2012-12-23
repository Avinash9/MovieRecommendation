package com.hashedIn.TestCases;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.hashedIn.Exceptions.MovieException;
import com.hashedIn.Manager.Manager;
import com.hashedIn.Manager.MovieByGenre;
import com.hashedIn.Model.Movie;

public class MovieByGenreTest {

	@Test
	public void test() throws MovieException {
		MovieByGenre obj = new MovieByGenre(); 
		Manager obj1 = new Manager();
		obj1.movieParsing();
		obj1.ratingParsing();
		try
		{
			obj.byGenre(obj1.getRatingList());
		}
		catch(MovieException me)
		{
			me.toString();
		}
		Map<Integer, Movie> testMap = obj.getTopMovieByGenre(obj1.getMovieList());
		//System.out.println("dummy test "+testMap);
		//System.out.println(testMap.get(1).getMovieId());
		assertEquals("50", testMap.get(1).getMovieId());
		
		
		
	}

}
