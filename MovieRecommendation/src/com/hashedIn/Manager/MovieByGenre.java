package com.hashedIn.Manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.hashedIn.Exceptions.MovieException;
import com.hashedIn.Model.Movie;
import com.hashedIn.Model.Ratings;

/**
 * 
 * @author avinash
 *Class MovieByGenre is calculating movie on differnt parameters.
 *having methods
 *byGenre(List<String> ratingList)
 *getTopMovieByGenre(List<Movie>  movieList)
 *highestRatedMovie(List<Movie>  movieList)
 * mostActiveUser(List<String> ratingList)
 */
public class MovieByGenre implements IMovieByGenre
{
	private Map<Integer, Integer> movieRatingMap ;  
	private Map<Integer, Integer> movieRatingByUser = null;
	/**
	 *byGenre method will calculate the method according to byGenre
	 */
	public void byGenre(List<String> ratingList) throws MovieException
	{
		movieRatingMap = new HashMap<Integer, Integer>();
		movieRatingByUser = new HashMap<Integer, Integer>();
		
		try
		{
			for(int i=0;i<ratingList.size()-1;i+=4)
			{
				int key=Integer.parseInt(ratingList.get(i+1));
				if(movieRatingMap.containsKey(key))
				{
					Integer a = movieRatingMap.get(key);
					movieRatingMap.put(key,a+Integer.parseInt(ratingList.get(i+2)));
					Integer b = movieRatingByUser.get(key);
					movieRatingByUser.put(key, ++b);
				}
				else
				{
				
					movieRatingMap.put(key, Integer.parseInt(ratingList.get(i+2)));
					movieRatingByUser.put(key,1);	
				}
				
			}
			
		}
		catch(Exception e)
		{
			throw new MovieException("Problem Encounter During Genre Processing");
		}
		
	}
	
	/**
	 * getTopMovieByGenre will get the top movie accoding to the genre
	 */
	public Map<Integer, Movie> getTopMovieByGenre(List<Movie>  movieList)
	{
		double maxRating = -99999.000;
		Movie objMovie = new Movie();
		Map<Integer, Movie> topMovie = new HashMap<Integer, Movie>();
		for(Integer i=0;i<18;i++)
		{
			for(Movie obj:movieList)
			{
				if(obj.getGenre()==null)
					continue;
				
				Boolean flag = obj.getGenre().containsKey(i.toString());
				if(flag)
				{
					Integer movieId = obj.getMovieId();
					double movieRating = (double)movieRatingMap.get(movieId)/movieRatingByUser.get(movieId);
					if(movieRating > maxRating)
					{
						objMovie = obj;
						maxRating = movieRating;
					}
				}
				
				
			}
			System.out.println("*************************************");
			System.out.println("Movie By Genre");
			System.out.println("Genre: "+i+" Avg. Rating: "+maxRating+" Movie Detail: "+objMovie.toString());
			maxRating=-99999.00;
			objMovie=new Movie();
			topMovie.put(i, objMovie);
		}
		return topMovie;
	}
	/**
	 * 
	 * @param movieList
	 * highestRatedMovie method finding the movie getting highest rating
	 */
	public void highestRatedMovie(List<Movie>  movieList)
	{
		Map<Integer, Movie> watchMovie = new HashMap<Integer, Movie>();
		Integer key1=0;
		Integer max = Integer.MIN_VALUE;
	    for(Object key: movieRatingMap.keySet()) {
	        Integer tmp = movieRatingMap.get(key);
	        if(tmp.compareTo(max) > 0) {
	            max = tmp;
	            key1=(Integer) key;
	        }
	    }

	  
	    for(Movie obj:movieList)
		{
	    
			
			Integer j=obj.getMovieId();
			//System.out.println((j));
			if(key1==j)
			{ 
				Movie objMovie = new Movie();
				objMovie=obj;
				watchMovie.put(key1,objMovie);
			}
				
			}
	    
	    System.out.println("*************************************");
		System.out.println("Highest Rated Movie");
	    System.out.println(watchMovie);
	
	
		
		
    }
		
	/**
	 * 
	 * @param movieList
	 * @throws MovieException
	 * mostWatchMovie method is finding the movie from Rating.data amd movie.data the movie which is most watched
	 */
	
	public void mostWatchedMovie(List<Movie> movieList) throws MovieException
	{
	
		Map<Integer, Movie> mostWatchMovie = new HashMap<Integer, Movie>();
		Integer key1=0;
		Integer max = Integer.MIN_VALUE;
	    for(Object key: movieRatingByUser.keySet()) {
	        Integer tmp = movieRatingByUser.get(key);
	        if(tmp.compareTo(max) > 0) {
	            max = tmp;
	            key1=(Integer) key;
	        }
	    }

		
	    for(Movie obj:movieList)
		{
	    
			
			Integer j=obj.getMovieId();
			
			if(key1==j)
			{ 
				Movie objMovie = new Movie();
				objMovie=obj;
				mostWatchMovie.put(key1,objMovie);
			}
				
			}
	    
	    System.out.println("*************************************");
		System.out.println("Most watched Movie");
	    System.out.println(mostWatchMovie);
	
	}
	/**
	 * 
	 * @param ratingList
	 * @throws MovieException
	 * mostActiveUser method is calculating the userid, the most active user
	 */
	public void mostActiveUser(List<String> ratingList) throws MovieException
	{
		Map<Integer, Integer> activeUser = new HashMap<Integer,Integer>();
		try
		{
			for(int i=0;i<ratingList.size()-1;i+=4)
			{
				int key=Integer.parseInt(ratingList.get(i));
				if(activeUser.containsKey(key))
				{
					Integer b = activeUser.get(key);
					activeUser.put(key, ++b);
				}
				else
				{
				
					activeUser.put(key,1);	
				}
				
			}
			
		}
		catch(Exception e)
		{
			throw new MovieException("Problem Encounter During Genre Processing");
		}
		Integer key1=0;
		Integer max = Integer.MIN_VALUE;
	    for(Object key: activeUser.keySet()) {
	        Integer tmp = activeUser.get(key);
	        if(tmp.compareTo(max) > 0) {
	            max = tmp;
	            key1=(Integer) key;
	        }
	    }
		System.out.println("+++++++++++++++++++++++++++++++++++++==");
		System.out.println("User Id "+key1+" is most active user");
		
	}
	

}
