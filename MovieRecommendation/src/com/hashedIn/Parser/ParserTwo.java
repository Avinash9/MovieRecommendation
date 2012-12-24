package com.hashedIn.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ParserTwo
{
	/**
	 * 1.get the file 2.parse the movie file 3. get the movieid,moviename,genre
	 * 4.store into a object.
	 * This parser will parse accoding to spaces.
	 */

	private List<String> list=null;
	private String filename;

	public void parseFile() 
	{
		list=new ArrayList<String>();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = "";
			StringTokenizer token = null;


			while ((line = br.readLine()) != null) {


				token=new StringTokenizer(line,"\t");

				while (token.hasMoreTokens()) 
				{

					list.add(token.nextToken());

				}

			}

		} catch (Exception e) {
			System.err.println("Parse Error: " + e.getMessage());
		}
	}

	public List<String> getList() {
		return list;
	}

	public void setfilename(String filename)
	{
		this.filename=filename;
	}

}
