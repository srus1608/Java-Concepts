package com.cisco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class crud_operations {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/cisco_db?useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Welcome123";
    private static final String TABLE_NAME = "profile1";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            System.out.println("--- Profile Database Operations ---");

            // --- 1. Insert a new profile  ---
            System.out.println("\n--- First, let's insert a new profile ---");
            insertProfile(scanner, connection);

            // --- 2. Retrieve a profile by ID ---
            System.out.println("\n--- Retrieve Profile by ID ---");
            retrieveProfile(scanner, connection);

            // --- 3. Update a profile's name by ID ---
            System.out.println("\n--- Update Profile Name by ID ---");
            updateProfileName(scanner, connection);

            // --- 4. Retrieve the updated profile to confirm ---
            System.out.println("\n--- Retrieve Updated Profile to Confirm ---");
            retrieveProfile(scanner, connection);

            // --- 5. Delete a profile by ID ---
            System.out.println("\n--- Delete Profile by ID ---");
            deleteProfile(scanner, connection);

            // --- 6. Try to retrieve the deleted profile to confirm ---
            System.out.println("\n--- Try to Retrieve Deleted Profile (should not be found) ---");
            retrieveProfile(scanner, connection);


        } catch (Exception e) {
            
            System.err.println("An error occurred during database operations: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---  method for inserting a profile ---
    private static void insertProfile(Scanner scanner, Connection connection) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO " + TABLE_NAME + " (name, dob) VALUES (?, ?)")) {
            System.out.print("Enter Name for new profile: ");
            String name = scanner.nextLine();

            LocalDate dobLocalDate = null;
            boolean validDobInput = false;
            while (!validDobInput) {
                System.out.print("Enter Date of Birth (YYYY-MM-DD) for new profile: ");
                String dobString = scanner.nextLine();
                try {
                    dobLocalDate = LocalDate.parse(dobString);
                    validDobInput = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please use YYYY-MM-DD (e.g., 1990-01-15).");
                }
            }
            java.sql.Date dobSqlDate = java.sql.Date.valueOf(dobLocalDate);

            pstmt.setString(1, name);
            pstmt.setDate(2, dobSqlDate);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("New profile for '" + name + "' inserted successfully!");
            } else {
                System.out.println("Failed to insert new profile.");
            }
        }
    }

    // ---  method for retrieving a profile ---
    private static void retrieveProfile(Scanner scanner, Connection connection) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement("SELECT id, name, dob FROM " + TABLE_NAME + " WHERE id = ?")) {
            System.out.print("Enter ID to retrieve profile: ");
            int idToRetrieve = Integer.parseInt(scanner.nextLine()); 

            pstmt.setInt(1, idToRetrieve);

            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) { 
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    LocalDate dob = resultSet.getDate("dob").toLocalDate();
                    System.out.println("Found Profile:");
                    System.out.println("  ID: " + id);
                    System.out.println("  Name: " + name);
                    System.out.println("  DOB: " + dob);
                } else {
                    System.out.println("No profile found with ID: " + idToRetrieve);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID entered. Please enter a number.");
        }
    }

    // ---  method for updating a profile's name ---
    private static void updateProfileName(Scanner scanner, Connection connection) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement("UPDATE " + TABLE_NAME + " SET name = ? WHERE id = ?")) {
            System.out.print("Enter ID of profile to update: ");
            int idToUpdate = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter NEW Name for profile ID " + idToUpdate + ": ");
            String newName = scanner.nextLine();

            pstmt.setString(1, newName);
            pstmt.setInt(2, idToUpdate);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Profile with ID " + idToUpdate + " updated successfully! New name: " + newName);
            } else {
                System.out.println("No profile found with ID " + idToUpdate + " to update.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID entered. Please enter a number.");
        }
    }

    // ---  method for deleting a profile ---
    private static void deleteProfile(Scanner scanner, Connection connection) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE id = ?")) {
            System.out.print("Enter ID of profile to delete: ");
            int idToDelete = Integer.parseInt(scanner.nextLine());

            pstmt.setInt(1, idToDelete);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Profile with ID " + idToDelete + " deleted successfully!");
            } else {
                System.out.println("No profile found with ID " + idToDelete + " to delete.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID entered. Please enter a number.");
        }
    }
}