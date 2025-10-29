package com.cisco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestSelect {
	public static void main(String[] args) {
		try {
			// you must use password Welcome123 in the 3rd parameter
			Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/cisco_db?useSSL=false", "root", "Welcome123");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from profile1");
			// next() returns true if record is present
			// getInt(index), getString(index), getDouble(index), getDate(index)
			List<Profile> list = new ArrayList<Profile>();
			while(result.next()) {
				int id = result.getInt(1);
				String name = result.getString(2);
				LocalDate dob = result.getDate(3).toLocalDate();
				Profile profile = new Profile(id, name, dob);
				list.add(profile);
			}
			System.out.println(list);
			result.close();
			statement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
}