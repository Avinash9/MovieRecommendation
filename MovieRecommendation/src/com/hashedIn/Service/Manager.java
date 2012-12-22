
package com.hashedIn.Service;


import java.util.List;

import com.hashedIn.Parser.*;


public class Manager
{
	public void movieParsing()
	{
		ParserOne ps=new ParserOne();
		ps.setfilename("/home/avinash/Downloads/user.data");
		ps.parseFile();
		List<String> listMovie = ps.getList();
	}
	
	
	public static void main(String[] args)
	{
		ParserOne pOne=new ParserOne();
		pOne.parseFile();
		
	}

}
