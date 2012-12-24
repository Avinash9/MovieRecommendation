package com.hashedIn.Start;

import com.hashedIn.Exceptions.MovieException;
import com.hashedIn.Manager.Manager;
/**
 * 
 * @author avinash
 *Starting class having the main method
 */
public class Service {

	/**
	 * @param args
	 * @throws MovieException 
	 * This is the Start Class having main method 
	 */
	public static void main(String[] args) throws MovieException 
	{
		Manager m=new Manager();
		m.movieParsing();
		m.userParsing();
		m.ratingParsing();
		
	}

}
