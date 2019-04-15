package com.vsr.java8.examples.lambda.funcinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest<T> {

	public static void main(String[] args) {
		List<Integer> integers = map(Arrays.asList("lambdas","in","action"), 
				(String s) -> s.length());
		System.out.println(integers);
	}

	public static List<Integer> map(List<String> strings, Function<String, Integer> f){
		List<Integer> results = new ArrayList<>();
		for(String s : strings) {
				results.add(f.apply(s));
		}
		return results;
	}
}
