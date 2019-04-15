package com.vsr.java8.examples.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppleFilterTest {
	 
	public static void main(String [] args) {
		
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
				new Apple(155, "green"),
				new Apple(160, "red"),
                new Apple(120, "red"));
				
		List<Apple> greenApples =
				AppleFilter.filterApples(inventory, new AppleGreenColorPredicate());
		System.out.println("Green Apples "+greenApples);
		
		List<Apple> redAndHeaveApples =
				AppleFilter.filterApples(inventory, new AppleRedAndHeavyPredicate());
		System.out.println("Red & Heavy Apples "+redAndHeaveApples);
		
		List<Apple> heavyApples =
				AppleFilter.filterApples(inventory, new ApplePredicate() {					
					public boolean test(Apple apple) {
						return "green".equalsIgnoreCase(apple.getColor());
					}
				});
		
		System.out.println("Heavy Apples "+heavyApples);
	
	}
}
