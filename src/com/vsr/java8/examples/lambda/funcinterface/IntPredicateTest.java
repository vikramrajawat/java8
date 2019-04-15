package com.vsr.java8.examples.lambda.funcinterface;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class IntPredicateTest<T> {

	public static void main(String[] args) {
		
		IntPredicate evenNumber = (int i) -> i % 2 == 0;
		System.out.println(evenNumber.test(1000));
		
		Predicate<Integer> oddNumber = (Integer i) -> i % 2 == 1;
		System.out.println(oddNumber.test(1000));
		
	}
}
