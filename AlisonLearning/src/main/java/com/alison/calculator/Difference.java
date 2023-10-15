package com.alison.calculator;

public class Difference {
	
	private int getDifference(int a, int b) {
		return a - b;
	}
	
	public void showDifferenceAnswer(int a, int b) {
		System.out.println("The answer is: " + getDifference(a, b));
	}


}
