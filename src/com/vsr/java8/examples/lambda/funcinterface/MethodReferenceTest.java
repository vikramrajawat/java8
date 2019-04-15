package com.vsr.java8.examples.lambda.funcinterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.vsr.java8.examples.lambda.Apple;
import com.vsr.java8.examples.lambda.AppleFilter;

public class MethodReferenceTest {
	 
	public static void main(String [] args) {
		        
        List<Apple> inventory = Arrays.asList(new Apple(85,"green"),
				new Apple(15, "green"),
				new Apple(140, "brown"),
                new Apple(170, "red"));
        
        // Method Reference
        inventory.sort(Comparator.comparing(Apple::getWeight));
        
        System.out.println("Inventory"+inventory);
                
        inventory.forEach(System.out::println);
        
        Supplier<Apple> appleSupplier = Apple::new;
        
        Apple apple = appleSupplier.get();
        
        // Composing Comparators
        
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
        
        System.out.println("Reserved inventory"+inventory);
        
        inventory.sort(Comparator.comparing(Apple::getWeight).
        		reversed().
        		thenComparing(Apple::getColor));
        
        System.out.println("Sorted by weight and then color ");
        
        inventory.forEach(System.out::println);
        
        // Composing Predicates
        
        Predicate<Apple> redApplePredicate = (Apple a) -> "red".equals(a.getColor());
        
        Predicate<Apple> nonRedApplePredicate = redApplePredicate.negate();
		
        Predicate<Apple> redAndHeaveApplePredicate = redApplePredicate.and((a) -> a.getWeight() > 150);
		
	}
}
