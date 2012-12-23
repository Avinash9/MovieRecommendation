package com.hashedIn.Exceptions;

public class MovieException extends Exception {

	String msg;
	
	public MovieException(String str)
	{
		this.msg = str;
	}

	@Override
	public String toString() {
		return "MovieException [msg=" + msg + "]";
	}
}
