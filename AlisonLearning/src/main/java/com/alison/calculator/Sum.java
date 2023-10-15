package com.alison.calculator;

public class Sum {

	private int getSum(int a, int b) {
		return a + b;
	}
	
	public void showSumAnswer(int a, int b) {
		System.out.println("The answer is: " + getSum(a, b));
	}
}
