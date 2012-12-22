
package com.hashedIn.Manager;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hashedIn.Model.Movie;
import com.hashedIn.Parser.*;


public class Manager
{
	
	private List<Movie> movieList=null;
	
	public void movieParsing()
	{
		ParserOne ps=new ParserOne();
		ps.setfilename("/home/avinash/Downloads/movie.data");
		ps.parseFile();
		List<String> listMovie = ps.getList();
		movieList = new ArrayList<Movie>();
		System.out.println(listMovie.size());
		System.out.println(listMovie.get(0));
		
		/*for(int i=0;i<listMovie.size();i++)
		{	
			Movie objMovie =  new Movie();
			objMovie.setMovieId(Integer.parseInt(listMovie.get(i++)));
			System.out.println(listMovie.get(i));
			objMovie.setMovieTitle(listMovie.get(i++));
			objMovie.setReleaseDate(listMovie.get(i++));
			objMovie.setVideoReleaseDate(listMovie.get(i++));
			objMovie.setImdbUrl(listMovie.get(i++));
			Map<String,Integer> genre = new HashMap<String,Integer> ();
			
			for(Integer j=0;j<=17;j++)
			{
				if(listMovie.get(i++).equals("1"))
				{
					genre.put(j.toString(),1);
				}
			}
			//System.out.println(genre.toString());
			objMovie.setGenre(genre);
			movieList.add(objMovie);
			//System.out.println(objMovie);
		}
		
		*/
		//System.out.println(movieList.toString());
		
	}
	public void ratingParsing()
	{
		
		ParserTwo ps=new ParserTwo();
		ps.setfilename("/home/avinash/Downloads/ratings.data");
		ps.parseFile();
		List<String> ratingList=ps.getList();
		//System.out.println(ratingList.toString());
		new MovieByGenre().byGenre(ratingList);
		
		
	}
	public void userParsing()
	{
		ParserOne ps=new ParserOne();
		ps.setfilename("/home/avinash/Downloads/user.data");
		ps.parseFile();
		List<String> userList=ps.getList();
		//System.out.println(userList.toString());
	}
	
	public void getTopMovieByGenre()
	{
		Map<Integer, String> topMovie = new HashMap<Integer, String>();
		for(Integer i=0;i<18;i++)
		{
			for(Movie obj:movieList)
			{
				if(obj.getGenre().containsValue(i))
				{
					obj.getMovieId();
				}
			}
		}
	}
	

}
