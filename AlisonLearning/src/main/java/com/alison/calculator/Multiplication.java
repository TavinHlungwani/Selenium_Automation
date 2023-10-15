package com.alison.calculator;

public class Multiplication {

	private int getMultiplication(int a, int b) {
		return a * b;
	}
	
	public void showMultiplicationAnswer(int a, int b) {
		System.out.println("The answer is: " + getMultiplication(a, b));
	}
}
