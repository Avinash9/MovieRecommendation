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

public class MovieByGenre implements IMovieByGenre
{
	private Map<Integer, Integer> movieRatingMap ;  
	private Map<Integer, Integer> movieRatingByUser = null;
	
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
			//System.out.println(movieRatingMap);
		}
		catch(Exception e)
		{
			throw new MovieException("Problem Encounter During Genre Processing");
		}
		
	}
	
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
	public void mostWatchedMovie(List<Movie>  movieList)
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

	   // System.out.println("key"+key1+"value"+max);
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
		
	
	

}
