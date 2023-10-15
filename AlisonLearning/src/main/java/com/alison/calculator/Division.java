package com.alison.calculator;

public class Division {
	
	private int getDivision(int a, int b) {
		int c = a / b;
		return c;
	}
	
	public void showDivisionAnswer(int a, int b) {
		System.out.println("The answer is: " + getDivision(a, b));
	}

}
