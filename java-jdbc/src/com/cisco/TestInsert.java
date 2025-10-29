package com.cisco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class TestInsert {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/cisco_db?useSSL=false", "root", "Welcome123");
			/*
			 * Statement decreases the performance when it modifies the table each time because it compiles
			 * the query each time and executes
			 * PreparedStatement compiles the query and stores in the cache by directly executing the
			 * query without re-compiling, that increases performance
			 */
			PreparedStatement pstmt = connection.prepareStatement("insert into profile1(name, dob) values(?,?)");
			System.out.println("Enter name");
			pstmt.setString(1, scan.next()); // reads the input & sets value to 1st ?
			System.out.println("Enter dob");
			LocalDate dob = LocalDate.parse(scan.next());
			pstmt.setDate(2, Date.valueOf(dob)); // java.sql.Date
			int count = pstmt.executeUpdate(); // you are not passing the query
			System.out.println("Row updated: "+count);
			pstmt.close();
			connection.close();
			scan.close();			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}