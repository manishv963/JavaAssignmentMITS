package com.mits.assignment.JavaAssignment.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamExample {

	
	public List<Integer> getSquareOfNumbers(List<Integer> numbersList) {
		
		List<Integer> resultList = new ArrayList<>();
		resultList = numbersList.stream().map( i -> i *i).collect(Collectors.toList());
		return resultList;
		
		
	}
	
public List<Integer> getEvenSquareOfNumbers(List<Integer> numbersList) {
		
		List<Integer> resultList = new ArrayList<>();
		resultList = numbersList.stream().filter( i -> i%2 == 0).map( i -> i *i).collect(Collectors.toList());
		return resultList;
		
		
	}
}
