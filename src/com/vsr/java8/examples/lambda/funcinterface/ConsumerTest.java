package com.vsr.java8.examples.lambda.funcinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest<T> {

	public static void main(String[] args) {
		forEach(Arrays.asList(1,2,4,5,6), (Integer i) -> System.out.println(i) );
	}

	public static void forEach(List<Integer> list, Consumer<Integer> c) {
		for(Integer s : list) {
			c.accept(s);
		}
	}
	
}
