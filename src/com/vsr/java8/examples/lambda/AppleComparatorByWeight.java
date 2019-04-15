package com.vsr.java8.examples.lambda;

import java.util.Comparator;

public class AppleComparatorByWeight implements Comparator<Apple> {
	public int compare(Apple o1, Apple o2) {
		return o1.getWeight().compareTo(o2.getWeight());
	}
}