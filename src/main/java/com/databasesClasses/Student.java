package com.databasesClasses;

public class Student {

	String srn;
	String firstName;
	String lastName;
	int age;
	String branch;
	String userName;
	public Student(String srn, String firstName, String lastName, int age, String branch ,String userName) {
		super();
		this.srn = srn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.branch = branch;
		this.userName=userName;
	}
	public String getSrn() {
		return srn;
	}
	public void setSrn(String srn) {
		this.srn = srn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
