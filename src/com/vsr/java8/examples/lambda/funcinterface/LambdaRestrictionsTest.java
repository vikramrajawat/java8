package com.vsr.java8.examples.lambda.funcinterface;

public class LambdaRestrictionsTest<T> {

	public static void main(String[] args) {

		int portNumber = 1337;
		Runnable r = () -> System.out.println(portNumber);
		r.run();
//		portNumber=120; // Fails if its not final
	}

}
