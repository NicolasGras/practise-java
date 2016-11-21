package com.ngr.java.entity;

/**
 * Entity class
 */
public class Client {

	private String name;
	private String firstname;
	private int age;
	
	public Client(String name, String firstname, int age) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.age = age;
	}		

	@Override
	public String toString() {
		return "Client [name=" + name + ", firstname=" + firstname + ", age=" + age + "]";
	}


	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstname;
	}

	public int getAge() {
		return age;
	}

}
