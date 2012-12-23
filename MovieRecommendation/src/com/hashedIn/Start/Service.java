package com.hashedIn.Start;

import com.hashedIn.Exceptions.MovieException;
import com.hashedIn.Manager.Manager;

public class Service {

	/**
	 * @param args
	 * @throws MovieException 
	 */
	public static void main(String[] args) throws MovieException 
	{
		Manager m=new Manager();
		m.movieParsing();
		m.userParsing();
		m.ratingParsing();
	}

}
