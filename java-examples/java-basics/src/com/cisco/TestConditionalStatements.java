package com.cisco;

public class TestConditionalStatements {
	public static void main(String[] args) {
		int counter1 = 15;
		int counter2 = 16;
		if(counter1 != counter2) {
			System.out.println("counter1 != counter2");
		} else {
			System.out.println("counter1 == counter2");
		}
		// ternary operator
		System.out.println((counter1!=counter2) ? "counter1 != counter2" : "counter1 == counter2");
		// if else if else if else
		if(counter1 > 100) {
			System.out.println("counter1 > 100");
		} else if(counter1 > 50) {
			System.out.println("counter1 > 50");
		} else if(counter1 > 10) {
			System.out.println("counter1 > 10");
		} else {
			System.out.println("counter1 <= 10");
		}
	}
}