package com.cisco;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestDateTime {
	public static void main(String[] args) {
		// LocalDate, LocalDateTime & LocalTime - Java 8
		LocalDate today = LocalDate.now();
		LocalDate dob = LocalDate.parse("2024-10-15"); // yyyy-MM-dd
		System.out.println(today);
		System.out.println(dob);
		System.out.println(dob.isBefore(today));
		LocalTime time = LocalTime.now();
		System.out.println(time);
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
	}
}