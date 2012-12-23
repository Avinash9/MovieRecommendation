package com.hashedIn.Manager;

import java.util.List;
import java.util.Map;

import com.hashedIn.Model.Movie;
/**
 * 
 * @author avinash
 * This interface is for Manager class an MovieByGenre class
 *and having method for finding top movie by genre.
 */
public interface IMovieByGenre
{
	public Map<Integer, Movie> getTopMovieByGenre(List<Movie>  movieList);

}
