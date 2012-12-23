package com.hashedIn.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hashedIn.Exceptions.MovieException;
import com.hashedIn.Model.Movie;
import com.hashedIn.Parser.*;

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

	public void movieParsing() {
		ParserOne ps = new ParserOne();
		ps.setfilename("/home/avinash/Downloads/movie.data");
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

	public void ratingParsing() throws MovieException {

		ParserTwo ps = new ParserTwo();
		ps.setfilename("/home/avinash/Downloads/ratings.data");
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

	}

	public void userParsing() {
		ParserOne ps = new ParserOne();
		ps.setfilename("/home/avinash/Downloads/user.data");
		ps.parseFile();
		List<String> userList = ps.getList();
	}
}
