package com.vsr.java8.examples.lambda;

public class AppleRedAndHeavyPredicate implements ApplePredicate {
	public boolean test(Apple apple) {
		return "red".equals(apple.getColor()) && apple.getWeight() > 150;
	}
}