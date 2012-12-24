package com.hashedIn.Parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParserOne {
	/**
	 * 1.get the file 2.parse the movie file 3. get the movieid,moviename,genre
	 * 4.store into a object.
	 * This parser will remove the | grom file and stored into a list
	 */

	private String filename;
	public List<String> list = null;

	public void parseFile() {
		list = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split("\\|");
				for (int i = 0; i < tokens.length; i++) {
					list.add(tokens[i]);
				}

			}

		} catch (Exception e) {
			System.err.println("Parse Error: " + e.getMessage());
		}

	}

	public List<String> getList() {
		return list;
	}

	public void setfilename(String filename) {
		this.filename = filename;
	}

}
