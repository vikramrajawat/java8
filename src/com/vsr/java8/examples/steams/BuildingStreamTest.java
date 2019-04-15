package com.vsr.java8.examples.steams;

import java.util.stream.Stream;

public class BuildingStreamTest {

	public static void main(String... args) {

		Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);

		Stream<String> emptyStream = Stream.empty();

		Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);		
		
		Stream.generate(Math::random).limit(5).forEach(System.out::println);
		
	}
}
