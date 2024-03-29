package com.hashedIn.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hashedIn.Exceptions.MovieException;
import com.hashedIn.Model.Movie;
import com.hashedIn.Model.User;
import com.hashedIn.Parser.*;

/**
 * 
 * @author avinash
 * Manager class is a class between parse and other classes.
 *having methods
 *public void movieParsing()
 *public void ratingParsing()
 *public void userParsing()
 */
public class Manager {

	private List<Movie> movieList = null;
	List<String> ratingList = null;

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public List<String> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<String> ratingList) {
		this.ratingList = ratingList;
	}
	/**
	 * movieParsing mthod will parse the data from movie.data
	 */

	public void movieParsing() {
		ParserOne ps = new ParserOne();
		ps.setfilename("movie.data");
		ps.parseFile();
		List<String> listMovie = ps.getList();
		movieList = new ArrayList<Movie>();

		for (int i = 0; i < listMovie.size() - 1; i++) {
			Movie objMovie = new Movie();
			objMovie.setMovieId(Integer.parseInt(listMovie.get(i++)));
			objMovie.setMovieTitle(listMovie.get(i++));
			objMovie.setReleaseDate(listMovie.get(i++));
			objMovie.setVideoReleaseDate(listMovie.get(i++));
			objMovie.setImdbUrl(listMovie.get(i++));
			Map<String, Integer> genre = new HashMap<String, Integer>();

			for (Integer j = 0; j <= 17; j++) {
				if (listMovie.get(i++).equals("1")) {
					genre.put(j.toString(), 1);
				}
			}

			objMovie.setGenre(genre);
			//System.out.println(genre);
			movieList.add(objMovie);
			//System.out.println(movieList);
		}

	}
	
	/**
	 *ratingparser mthod will parse the data fromratings.data
	 */

	public void ratingParsing() throws MovieException {

		ParserTwo ps = new ParserTwo();
		ps.setfilename("ratings.data");
		ps.parseFile();
		ratingList = ps.getList();
		movieParsing();
		MovieByGenre obj = new MovieByGenre();
		try
		{
			obj.byGenre(ratingList);
		}
		catch(MovieException me)
		{
			me.toString();
		}
		obj.getTopMovieByGenre(movieList);
		obj.highestRatedMovie(movieList);
		obj.mostWatchedMovie(movieList);
		obj.mostActiveUser(ratingList);
	}
	/**
	 * userparsing mthod will parse the data from user.data
	 */

	public void userParsing() {
		ParserOne ps = new ParserOne();
		ps.setfilename("user.data");
		ps.parseFile();
		List<String> userList = ps.getList();
		
		
	}
}
