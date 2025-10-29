package com.cisco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Scanner;

public class TestTransaction {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try { 
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/cisco_db?useSSL=false", "root", "Welcome123");
			// enable transaction
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection.prepareStatement("insert into profile1(name, dob) values(?,?)");
			for(int i = 1; i <= 5; i++) {
				System.out.println("Enter name");
				pstmt.setString(1, scan.next()); // reads the input & sets value to 1st ?
				System.out.println("Enter dob");
				LocalDate dob = LocalDate.parse(scan.next());
				pstmt.setDate(2, Date.valueOf(dob)); // java.sql.Date
				int count = pstmt.executeUpdate(); // you are not passing the query
				System.out.println("Row updated: "+count);
				if(i == 3) {
					connection.rollback(); // think something went wrong
				}
			}
			connection.commit();
			pstmt.close();
			connection.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		scan.close();
	}
}