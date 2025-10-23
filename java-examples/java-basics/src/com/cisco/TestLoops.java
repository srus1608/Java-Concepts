package com.cisco;

public class TestLoops {
	public static void main(String[] args) {
		int[] items = {8, 6, 1, 2, 3};
		// traditional for loop
		for(int index = 0; index < items.length; index++) {
			System.out.println("Index = "+index+", Item = "+items[index]);
		}
		// enhanced for loop or for each
		for(int item : items) {
			System.out.println("Item = "+item);
		}
		// while and do while keeps iterating until the condition is true
		int counter = 4; // file reading counter and its value becomes 0 when there are not data
		while(counter != 0) {
			System.out.println("While Counter != 0");
			counter--;
		}
		do {
			System.out.println("Do While Counter != 0");
		} while(counter != 0);
	}
}