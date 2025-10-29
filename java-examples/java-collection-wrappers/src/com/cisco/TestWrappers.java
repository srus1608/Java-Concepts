package com.cisco;

public class TestWrappers {
	public static void main(String[] args) {
		System.out.println("Ascii 65 is alphabet: "+Character.isAlphabetic(65));
		System.out.println("Is 1 a digit: "+Character.isDigit('1'));
		
		/*
		 *  compare 2 int or double that returns 0 or +1 or -1
		 * 0 means equal
		 * 1 means 1st argument is > 2nd argument
		 * -1 means 1st argument is < 2nd argument
		 * 4, 5, 1, 2, 3
		 */
		System.out.println("Compare 1 and 2: "+Integer.compare(1, 2));
		System.out.println("Compare 2 and 1: "+Integer.compare(2, 1));
		System.out.println("Compare 2 and 2: "+Integer.compare(2, 2));
		System.out.println("--- Comparing some list of numbers-----");
		System.out.println("Compare 4 and 5: "+Integer.compare(4, 5));
		System.out.println("Compare 4 and 1: "+Integer.compare(4, 1));
		System.out.println("Compare 4 and 2: "+Integer.compare(4, 2));
		System.out.println("----- Comparing double -----");
		System.out.println("Compare 2.5 and 3.5: "+Double.compare(2.5, 3.5));
	}
}