package com.cisco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class profile_enter_data {
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in);
             Connection connection = DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/cisco_db?useSSL=false", 
                 "root",                                            
                 "Welcome123"                                       
             );
             // Prepare the SQL INSERT statement here, 
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO profile1 (name, dob) VALUES (?, ?)")
        ) {

            System.out.println("--- Insert New Profile ---");

            // 1. Get User Input for Name
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            // 2. Get User Input for Date of Birth (with validation)
            LocalDate dobLocalDate = null;
            boolean validDobInput = false;
            while (!validDobInput) {
                System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
                String dobString = scanner.nextLine();
                try {
                    dobLocalDate = LocalDate.parse(dobString); 
                    validDobInput = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please use YYYY-MM-DD (e.g., 1990-01-15).");
                }
            }

            // Convert LocalDate to java.sql.Date, which JDBC expects for DATE columns
            java.sql.Date dobSqlDate = java.sql.Date.valueOf(dobLocalDate);

            // 3. Set the parameters for the PreparedStatement
            preparedStatement.setString(1, name);     // Set the FIRST '?' to the name
            preparedStatement.setDate(2, dobSqlDate); // Set the SECOND '?' to the DOB

            // 4. Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            // 5. Check if the insertion was successful
            if (rowsAffected > 0) {
                System.out.println("Profile for '" + name + "' inserted successfully!");
            } else {
                System.out.println("Failed to insert profile.");
            }

        } catch (Exception e) { // Catch all exceptions in one block for simplicity
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace(); // Still good to print the stack trace for debugging
        }
    }
}