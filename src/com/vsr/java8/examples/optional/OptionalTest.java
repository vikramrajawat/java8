package com.vsr.java8.examples.optional;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
//		test();
		testOptional();
		testOptionalOrElse();
		testOptionalCreation();
		testExtractionAndTransformation();
	}

	static void testExtractionAndTransformation() {
		Insurance insurance = new Insurance();
		Person person = new Person();
		
		Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
		Optional<String> name = Optional.ofNullable(insurance)
									.map(Insurance::getName).get();
		
		String name1 = Optional.ofNullable(person)
				.flatMap(Person::getCar)
		        .flatMap(Car::getInsurance)
		        .flatMap(Insurance::getName).orElse("Default Name");
		
	}

	static void testOptionalCreation() {
		Car car = new Car();
		Optional<Car> optCar = Optional.empty(); // Empty optional​
		Optional<Car> optCar1 = Optional.of(car); // Optional from a non-null value​
		Optional<Car> optCar2 = Optional.ofNullable(car); // Optional from null​
		System.out.println(optCar);
	}

	static void testOptionalOrElse() {
		String input = "Test Name";
		String name = Optional.of(input).orElse("Default Name");
		String name1 = Optional.of(input).orElseGet(() -> "Default Name");
		// input = null // uncomment this code to see exception
		String name2 = Optional.ofNullable(input).orElseThrow(() -> new IllegalStateException("No Data Found"));
	}

	static void testOptional() {

		String[] words = new String[10];
		Optional<String> optionalWord = Optional.ofNullable(words[5]);

		if (optionalWord.isPresent()) {
			String word = words[5].toLowerCase();
			System.out.print(word);
		} else {
			System.out.println("word is null");
		}
	}

	static void test() {
		String[] words = new String[10];
		String word = words[5].toLowerCase();
		System.out.print(word);
	}
}
