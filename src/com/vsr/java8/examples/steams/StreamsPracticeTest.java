
package com.vsr.java8.examples.steams;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsPracticeTest {

	public static void main(String... args) {

		// Get Dish Names which are low calorie in sorted order using Java 8
//		getSortedLowCalorieDishNames(Dish.menu).forEach(System.out::println);

//		getThreeHighCalorieDishNames(Dish.menu);

//		getVegetarianDishes(Dish.menu);

//		flateringStream();

		reduceStream();
	}

	public static List<String> getSortedLowCalorieDishNames(List<Dish> dishes) {
		return dishes.stream().filter(d -> d.getCalories() < 400).sorted(comparing(Dish::getCalories))
				.map(Dish::getName).collect(toList());
	}

	public static List<String> getThreeHighCalorieDishNames(List<Dish> dishes) {
		return dishes.stream().filter(d -> d.getCalories() > 300).map(Dish::getName).limit(3).collect(toList());
	}

	public static List<Dish> getVegetarianDishes(List<Dish> dishes) {
		return dishes.stream().filter(Dish::isVegetarian).collect(toList());
	}

	public void filterUnique() {
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
	}

	public List<Dish> truncateStream() {
		List<Dish> dishes = Dish.menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(toList());
		return dishes;
	}

	private void skipSteam() {
		List<Dish> dishes = Dish.menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList());
	}

	private void test() {
		if (Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("The menu is (somewhat) vegetarian friendly!!");
		}

		boolean isHealthy = Dish.menu.stream().allMatch(d -> d.getCalories() < 1000);

		boolean isFoodHealthy = Dish.menu.stream().noneMatch(d -> d.getCalories() >= 1000);

		Optional<Dish> dish = Dish.menu.stream().filter(Dish::isVegetarian).findAny();
	}

	private static void flateringStream() {
		List<String> words = Arrays.asList("Hello", "World");
		List<String> uniqueChars = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct()
				.collect(toList());

		uniqueChars.stream().collect(toList()).forEach(System.out::println);

	}

	private static void reduceStream() {
		List<Integer> numbers = Arrays.asList(4, 5, 3, 9);
		int sum = numbers.stream().reduce(0, (a, b) -> a + b);
		System.out.println("Sum " + sum);
		sum = numbers.stream().reduce(0, Integer::sum);
		System.out.println("Sum " + sum);
		Optional<Integer> sumOptional = numbers.stream().reduce((a, b) -> (a + b));
		System.out.println("Sum " + sumOptional.get());
		Optional<Integer> max = numbers.stream().reduce(Integer::max);
		Optional<Integer> min = numbers.stream().reduce(Integer::min);
		System.out.println("Min " + min + " max ");
		int count = Dish.menu.stream().map(d -> 1).reduce(0, (a, b) -> a + b);

		System.out.println("Count " + count);
		System.out.println(Dish.menu.stream().count());

		IntStream coloriesIntStream = Dish.menu.stream()
						.mapToInt(Dish::getCalories);

		int res = coloriesIntStream.sum();

		// Stream<Integer> intStreamBoxed = coloriesIntStream.boxed();

//		OptionalInt coloriesMaxOptionalInt = coloriesIntStream.max();

//		int maxOptional = coloriesMaxOptionalInt.orElse(10);

		IntStream evenNumbers = IntStream.range(1, 100).filter(n -> n % 2 == 0);

		System.out.println(evenNumbers.count());

		
		

	}
}
