package com.model;

public class Student {
	private int id;
	private int roll_no;
	private String name;
	private String city;
	
	public Student(int id, int roll_no, String name, String city) {
		super();
		this.id = id;
		this.roll_no = roll_no;
		this.name = name;
		this.city = city;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", roll_no=" + roll_no + ", name=" + name + ", city=" + city + "]";
	}
	
	

}
