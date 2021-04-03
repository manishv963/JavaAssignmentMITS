package com.mits.assignment.JavaAssignment.Employee;

public class EmployeeClass implements Comparable<EmployeeClass> {

	private int id;
	private String firstName;
	private String lastName;
	
	public EmployeeClass(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "EmployeeClass [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	@Override
	public int compareTo(EmployeeClass o) {
		// TODO Auto-generated method stub
		return Integer.compare(getId(), o.getId());
	}

	
	}
