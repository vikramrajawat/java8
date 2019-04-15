package com.vsr.java8.examples.steams;

import java.util.Arrays;

public class ArrayParallelSorting {

	public void arraySort() {
		int numbers[] = new int[1000000];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = 1;
		}
		// Parallel Sort method for sorting int array
		Arrays.parallelSort(numbers);
	}
}
