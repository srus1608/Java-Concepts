package com.cisco;

public class TestOperators {
	public static void main(String[] args) {
		int counter1 = 15;
		int counter2 = 15;
		int likes = ++counter1;
		int dislikes = counter2++; //value is assigned first to dislikes & then counter2 is increased
		System.out.println("Counter1 = "+counter1+", Likes = "+likes);
		System.out.println("Counter2 = "+counter2+", Dislikes = "+dislikes);
		System.out.println(counter1 == counter2);
		System.out.println(counter1 != counter2);
		System.out.println(counter1 <= counter2);
	}
}