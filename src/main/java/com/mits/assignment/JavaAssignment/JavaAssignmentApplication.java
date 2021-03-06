package com.mits.assignment.JavaAssignment;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mits.assignment.JavaAssignment.ThreadApplication.ThreadAssignment;

@SpringBootApplication
public class JavaAssignmentApplication {

	public static void main(String[] args) throws InterruptedException, IOException {
		ApplicationContext ctx = SpringApplication.run(JavaAssignmentApplication.class, args);
		ThreadAssignment threadTest =  (ThreadAssignment) ctx.getBean("threadAssignment");
		
		//String result =  threadTest.executeThreadAssignment();
		//System.out.println("Final Result "+result);
		//threadTest.executeThreadAssignment();

	}

}
