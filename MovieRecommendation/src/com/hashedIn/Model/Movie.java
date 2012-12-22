package com.hashedIn.Model;

import java.util.List;

public class Movie 
{

		 private int id;
	     public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public List<Genre> getGenres() {
			return genres;
		}
		public void setGenres(List<Genre> genres) {
			this.genres = genres;
		}
		private String  title;
	     private List<Genre>  genres;
	

}
