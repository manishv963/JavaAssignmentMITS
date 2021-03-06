package com.mits.assignment.JavaAssignment.Employee;

public class EmployeeClassFirstNameComparator implements Comparable<EmployeeClassFirstNameComparator> {

	private int id;
	private String firstName;
	private String lastName;
	
	public EmployeeClassFirstNameComparator(int id, String firstName, String lastName) {
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
		return "EmployeeClassFirstNameComparator [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	@Override
	public int compareTo(EmployeeClassFirstNameComparator o) {
		// TODO Auto-generated method stub
		char getFirstNameCharacter =  getFirstName().toLowerCase().charAt(0);
		
		int sum=0;
	    for(int i=0; i<getFirstName().toLowerCase().length(); i++)
	    {
	      int asciiValue = getFirstName().toLowerCase().charAt(i);
	      sum = sum+ asciiValue;
	      //System.out.println(str.charAt(i) + "=" + asciiValue);
	    }
	    
	    System.out.println( "sum=" + sum+" "+getFirstName());
	    int objectAsciiSum  = 0;
	    for(int i=0; i<o.getFirstName().toLowerCase().length(); i++)
	    {
	      int asciiValue = o.getFirstName().toLowerCase().charAt(i);
	      objectAsciiSum = objectAsciiSum+ asciiValue;
	      //System.out.println(str.charAt(i) + "=" + asciiValue);
	    }
	    System.out.println( "objectAsciiSum=" + objectAsciiSum+" "+o.getFirstName());
	    return Integer.compare(sum, objectAsciiSum);
	}

	
	}
