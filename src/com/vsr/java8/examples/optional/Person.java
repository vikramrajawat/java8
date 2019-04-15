package com.vsr.java8.examples.optional;

import java.util.*;

public class Person {

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

	public void setCar(Optional<Car> car) {
		this.car = car;
	}
    
    
}
