package com.hashedIn.Model;

import java.util.List;
import java.util.Map;

public class Movie 
{
	private int movieId;
	private String movieTitle;
	private String releaseDate;
	private String videoReleaseDate;
	private String imdbUrl;
	private Map<String,Integer> genre;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getVideoReleaseDate() {
		return videoReleaseDate;
	}
	public void setVideoReleaseDate(String videoReleaseDate) {
		this.videoReleaseDate = videoReleaseDate;
	}
	public String getImdbUrl() {
		return imdbUrl;
	}
	public void setImdbUrl(String imdbUrl) {
		this.imdbUrl = imdbUrl;
	}
	public Map<String, Integer> getGenre() {
		return genre;
	}
	public void setGenre(Map<String,Integer> genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle
				+ ", releaseDate=" + releaseDate + ", videoReleaseDate="
				+ videoReleaseDate + ", imdbUrl=" + imdbUrl + ", genre="
				+ genre + "]";
	}
	

}
