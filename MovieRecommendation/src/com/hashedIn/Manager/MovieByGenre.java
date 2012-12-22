package com.hashedIn.Manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieByGenre
{
	private Map<Integer, Integer> movieRatingMap =  null;  
	private Map<Integer, Integer> movieRatingByUser = null;
	public void byGenre(List<String> ratingList)
	{
		movieRatingMap = new HashMap<Integer, Integer>();
		movieRatingByUser = new HashMap<Integer, Integer>();
		System.out.println(ratingList.size());
		//System.out.println(ratingList.get(3));
		for(int i=0;i<ratingList.size();i+=4)
		{
			System.out.println();
			if(movieRatingMap.containsKey(Integer.parseInt(ratingList.get(i+1))))
			{
				Integer a = movieRatingMap.get(ratingList.get(i+1));
				movieRatingMap.put(Integer.parseInt(ratingList.get(i+1)),a+Integer.parseInt(ratingList.get(i+2)));
				Integer b = movieRatingByUser.get(ratingList.get(i+1));
				movieRatingByUser.put(Integer.parseInt(ratingList.get(i+1)), ++b);
			}
			else
			{
				movieRatingMap.put(Integer.parseInt(ratingList.get(i+1)), Integer.parseInt(ratingList.get(i+2)));
				movieRatingByUser.put(Integer.parseInt(ratingList.get(i+1)),1);	
			}
		}
		
	}

}
