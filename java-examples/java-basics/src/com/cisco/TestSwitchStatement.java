package com.cisco;

public class TestSwitchStatement {
	public static void main(String[] args) {
		int choice = 1;
		// switch can accept int, char, String
		switch(choice) {
		case 1 : System.out.println("Have your coffee");
		break;
		case 2: System.out.println("Have hot milk");
		break;
		case 3: System.out.println("Have hot water");
		break;
		default : System.out.println("No choice is selected");		
		}
		System.out.println("Thank you");
	}
}