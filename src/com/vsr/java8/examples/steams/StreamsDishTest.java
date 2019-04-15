package com.vsr.java8.examples.steams;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamsDishTest {

    public static void main(String...args){
        
    	// Get Dish Names which are low calorie in sorted order
    	
    	// Prior Java 8
    	getSortedLowCalorieDishNamesJava7(Dish.menu).forEach(System.out::println);

    	// Using Java 8
    	getSortedLowCalorieDishNamesJava8(Dish.menu).forEach(System.out::println);

    }

    public static List<String> getSortedLowCalorieDishNamesJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish d: dishes){
            if(d.getCalories() < 400){
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    public static List<String> getSortedLowCalorieDishNamesJava8(List<Dish> dishes){
        return dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }    
}
