package com.vsr.java8.examples.lambda.funcinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateTest<T> {

	public static void main(String[] args) {

		List<String> sessionStrings = Arrays.asList("Lambda","","in"," ","action");
		
		List<String> nonEmptyStrings = filter(sessionStrings, (String s) -> !s.isEmpty());
		
		System.out.println("nonEmptyStrings "+nonEmptyStrings);

	}

	public static List<String> filter(List<String> list, Predicate<String> p){
		List<String> results =  new ArrayList<>();
		for(String s : list) {
			if(p.test(s)) {
				results.add(s);
			}			
		}
		return results;
	}	

}
