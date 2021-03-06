package com.mits.assignment.JavaAssignment;

import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import com.mits.assignment.JavaAssignment.Employee.EmployeeClass;
import com.mits.assignment.JavaAssignment.Employee.EmployeeClassFirstNameComparator;
import com.mits.assignment.JavaAssignment.Employee.EmployeeClassHashCode;
import com.mits.assignment.JavaAssignment.Employee.EmployeeClassHashCodeEquals;
import com.mits.assignment.JavaAssignment.Streams.JavaStreamExample;
import com.mits.assignment.JavaAssignment.ThreadApplication.ThreadAssignment;

@SpringBootTest
class JavaAssignmentApplicationTests {

	@Test
	void contextLoads() {
	}
	
	
	@Test
	void testThreadAssignmentOutput() {
		ThreadAssignment threadTest =  new ThreadAssignment();
		String output = threadTest.executeThreadAssignment();
		//System.out.println("Sas " +output);
		output= output.substring(output.length()-1);
		//System.out.println("Sas " +output);
		
		assertEquals("5", output);
	}
	
	
	//since we  have not implemented hashcode and equals methods so set will not be able to identify the employee object
	@Test
	void testAddEmployeeWithoutHashCodeEquals() {
		EmployeeClass e1 = new EmployeeClass(1,"Manish", "Vasandnani");
		EmployeeClass e2 = new EmployeeClass(1,"Manish", "Vasandnani");
		Set<EmployeeClass> employeeSet = new HashSet<EmployeeClass>();
		employeeSet.add(e1);
		employeeSet.add(e2);
		System.out.println("Employee size "+employeeSet.size());
		assertEquals(2,employeeSet.size());
	}
		
	
	
	
	//By implementing hashcode method we are getting same hash values for both the object but then also set is considering both the elements
	@Test
	void testAddEmployeeWithHashCode() {
		EmployeeClassHashCode e1 = new EmployeeClassHashCode(1,"Manish", "Vasandnani");
		EmployeeClassHashCode e2 = new EmployeeClassHashCode(1,"Manish", "Vasandnani");
		Set<EmployeeClassHashCode> employeeSet = new HashSet<EmployeeClassHashCode>();
		employeeSet.add(e1);
		employeeSet.add(e2);
		System.out.println("Hashcode "+e1.hashCode());
		System.out.println("hascide "+e2.hashCode());
		System.out.println("Employee size "+employeeSet.size());
		assertEquals(2,employeeSet.size());
	}
	
	//after implementing hashcode and equals  set is able to identify both the employee object with the same details

	@Test
	void testAddEmployeeWithHashCodeAndEquals() {
		EmployeeClassHashCodeEquals e1 = new EmployeeClassHashCodeEquals(1,"Manish", "Vasandnani");
		EmployeeClassHashCodeEquals e2 = new EmployeeClassHashCodeEquals(1,"Manish", "Vasandnani");
		Set<EmployeeClassHashCodeEquals> employeeSet = new HashSet<EmployeeClassHashCodeEquals>();
		employeeSet.add(e1);
		employeeSet.add(e2);
		System.out.println("Hashcode equals "+e1.hashCode());
		System.out.println("hascide equals "+e2.hashCode());
		System.out.println("Employee size "+employeeSet.size());
		assertEquals(1,employeeSet.size());
	}

	
	//by default we are sorting the employee by Id
	@Test
	void testEmployeeTreeSetDefaultSorting() {
		try {
		EmployeeClass e1 = new EmployeeClass(1,"Manish", "Vasandnani");
		EmployeeClass e2 = new EmployeeClass(2,"Ashish", "Bajaj");
		EmployeeClass e3 = new EmployeeClass(3,"Kishore", "Ramchandani");
		Set<EmployeeClass> employeeTreeSet = new TreeSet<EmployeeClass>();
		employeeTreeSet.add(e1);
		employeeTreeSet.add(e2);
		employeeTreeSet.add(e3);
		for( EmployeeClass ee:employeeTreeSet) {
			System.out.println(ee.toString());
		}
		
		assertEquals(1,employeeTreeSet.iterator().next().getId());
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	//by default we are sorting the employee by Id
		@Test
		void testEmployeeTreeSetFirstName() {
			try {
				EmployeeClassFirstNameComparator e1 = new EmployeeClassFirstNameComparator(1,"Manish", "Vasandnani");
				
				EmployeeClassFirstNameComparator e2 = new EmployeeClassFirstNameComparator(2,"Ashis", "Bajaj");
				EmployeeClassFirstNameComparator e3 = new EmployeeClassFirstNameComparator(3,"Kishore", "Ramchandani");
				EmployeeClassFirstNameComparator e4 = new EmployeeClassFirstNameComparator(4,"Anuj", "Ramchandani");
				EmployeeClassFirstNameComparator e5 = new EmployeeClassFirstNameComparator(5,"Abc", "Rao");
				EmployeeClassFirstNameComparator e6 = new EmployeeClassFirstNameComparator(6,"Bhaskar", "Rao");

				Set<EmployeeClassFirstNameComparator> employeeTreeSet = new TreeSet<EmployeeClassFirstNameComparator>();
				
				employeeTreeSet.add(e1);
			employeeTreeSet.add(e2);
			employeeTreeSet.add(e3);
			employeeTreeSet.add(e4);
			employeeTreeSet.add(e5);
			employeeTreeSet.add(e6);
			System.out.println("first name sorting");
			for( EmployeeClassFirstNameComparator ee:employeeTreeSet) {
				System.out.println(ee.toString());
			}
			
			assertEquals("Abc",employeeTreeSet.iterator().next().getFirstName());
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
		@Test
		void testSquareofNumbers() {
			List<Integer> initialList = new ArrayList<Integer>();
			initialList.add(2);
			initialList.add(3);
			initialList.add(4);
			initialList.add(5);
			
			List<Integer> listToCompare = new ArrayList<Integer>();
			listToCompare.add(4);
			listToCompare.add(9);
			listToCompare.add(16);
			listToCompare.add(25);
			List<Integer> resultList =new JavaStreamExample().getSquareOfNumbers(initialList);
			System.out.println(resultList);
			assertEquals(resultList,listToCompare);
		}

		@Test
		void testEvenSquarefNumbers() {
			List<Integer> initialList = new ArrayList<Integer>();
			initialList.add(2);
			initialList.add(3);
			initialList.add(4);
			initialList.add(5);
			
			List<Integer> listToCompare = new ArrayList<Integer>();
			listToCompare.add(4);
			listToCompare.add(16);
			
			List<Integer> resultList =new JavaStreamExample().getEvenSquareOfNumbers(initialList);
			System.out.println(resultList);
			assertEquals(resultList,listToCompare);
		}
		
		@Test
		void testTryWithResource() {
			
			String data ="";
			Resource resource = new ClassPathResource("/test.txt");
			
			try (InputStream inputStream = resource.getInputStream();
					){
	            
	             data = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
	            System.out.println(data);
	            
	        } catch (IOException e) {
	            System.out.println("IOException"+ e);
	        }
			assertEquals("Manish",data);
			
		}
}
