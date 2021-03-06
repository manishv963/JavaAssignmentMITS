package com.mits.assignment.JavaAssignment.ThreadApplication;

import org.springframework.stereotype.Component;

@Component
public class ThreadAssignment {
	public static String resultString = "";
	public String executeThreadAssignment(){
		
		Thread1 t1 =  new Thread1();
		Thread2 t2 =  new Thread2();
		Thread3 t3 =  new Thread3();
		Thread4 t4 =  new Thread4();
		Thread5 t5 =  new Thread5();
		
		while(t5.getState().toString().equals("TERMINATED")  == false) {
		try {
		if(t1.getState().toString().equals("NEW")) 
			t1.start();
		
		if(t2.getState().toString().equals("NEW"))
			t2.start();
		if(t3.getState().toString().equals("NEW"))
			t3.start();

		if(t4.getState().toString().equals("NEW"))
			t4.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		
		if(t5.getState().toString().equals("NEW"))
			t5.start();
		

		}
		catch(Exception e) {
			System.out.println(e);
		}
		//System.out.println("hello "+ resultString);
		
		}	
			return resultString;
	
		
	}
}


class Thread1 extends Thread{

	@Override
	public void run() {
		System.out.println("Thread 1");
		ThreadAssignment.resultString = ThreadAssignment.resultString+"1";
		//System.out.println(ThreadAssignment.resultString);
	}
	
}
class Thread2 extends Thread{

	@Override
	public void run() {
		System.out.println("Thread 2");
		ThreadAssignment.resultString = ThreadAssignment.resultString+"2";
	}

	
}
class Thread3 extends Thread{

	@Override
	public void run() {
		System.out.println("Thread 3");
		ThreadAssignment.resultString = ThreadAssignment.resultString+"3";
	}
	
}
class Thread4 extends Thread{

	@Override
	public void run() {
		System.out.println("Thread 4");
		ThreadAssignment.resultString = ThreadAssignment.resultString+"4";
	}
	
}
class Thread5 extends Thread{

	@Override
	public void run() {
		System.out.println("Thread 5");
		ThreadAssignment.resultString = ThreadAssignment.resultString+"5";
	}
	
}

