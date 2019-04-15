package com.vsr.java8.examples.lambda;

import java.util.ArrayList;
import java.util.List;

public class AppleFilter {
		public static List<Apple> filterApples(List<Apple> apples, ApplePredicate predicate) {
			List<Apple> result = new ArrayList<>();
			for (Apple apple : apples) {
				if (predicate.test(apple)) {
					result.add(apple);
				}
			}
			return result;
		}
}
