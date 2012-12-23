package com.hashedIn.Manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hashedIn.Exceptions.MovieException;
import com.hashedIn.Model.Movie;

public class MovieByGenre
{
	private Map<Integer, Integer> movieRatingMap ;  
	private Map<Integer, Integer> movieRatingByUser = null;
	
	public void byGenre(List<String> ratingList) throws MovieException
	{
		movieRatingMap = new HashMap<Integer, Integer>();
		movieRatingByUser = new HashMap<Integer, Integer>();
		System.out.println(ratingList.size());
		
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
			
			System.out.println("Genre: "+i+" Avg. Rating: "+maxRating+" Movie Detail: "+objMovie.toString());
			maxRating=-99999.00;
			objMovie=new Movie();
			topMovie.put(i, objMovie);
		}
		return topMovie;
	}
	

}
