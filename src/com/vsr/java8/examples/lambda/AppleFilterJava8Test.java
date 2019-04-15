package com.vsr.java8.examples.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AppleFilterJava8Test {
	 
	public static void main(String [] args) {
		
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
				new Apple(155, "green"),
				new Apple(160, "red"),
                new Apple(120, "red"));
		
		List<Apple> greenApples = AppleFilter.filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
		
		System.out.println(greenApples);
        
        List<Apple> heavyApples = AppleFilter.filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples);
        
        List<Apple> weirdApples = AppleFilter.filterApples(inventory, (Apple a) -> a.getWeight() < 80 || 
                                                                       "brown".equals(a.getColor()));
        System.out.println(weirdApples);
        
        // (a) -> "green".equals(a.getColor())
        // (a) -> a.getWeight() > 150
        // (a) -> a.getWeight() < 80 || "brown".equals(a.getColor())
        
        System.out.println("inventory "+inventory);
        
        inventory.sort(
        		(a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        
        System.out.println("inventory "+inventory);
        
        List<Apple> inventory2 = Arrays.asList(new Apple(85,"green"),
				new Apple(15, "green"),
				new Apple(140, "brown"),
                new Apple(170, "red"));
		
        System.out.println("inventory2 "+inventory2);
        inventory2.sort(new AppleComparatorByWeight());
        System.out.println("inventory2 "+inventory2);
        
        inventory.sort(new Comparator<Apple>() {
        	public int compare(Apple o1, Apple o2) {
        		 return o1.getWeight().compareTo(o2.getWeight());
        	};
		});
        
        List<Apple> inventory3 = Arrays.asList(new Apple(85,"green"),
				new Apple(15, "green"),
				new Apple(140, "brown"),
                new Apple(170, "red"));
        inventory3.sort(java.util.Comparator.comparing(Apple::getWeight));
        System.out.println(inventory3);
        
        System.out.println("System.out::println");
        inventory.forEach(System.out::println);
	}
}
