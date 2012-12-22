package com.hashedIn.Model;


public class User 
{
	private int  id;
    private char gender;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	private int   age;
    private String  occupation;
    private String   zipcode;

}
