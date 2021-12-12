package com.project.pack;

import java.sql.*;
import java.util.Scanner;

public class User {
    String jdbcURL = "jdbc:mysql://localhost:3306/patientdb";
    String username = "root";
    String password = "projects@123";
    Scanner Sw1 = new Scanner(System.in);

    public void showAllPatientDetails() {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "SELECT * from patienttable";
            Statement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int patientID = result.getInt(1);
                String patientName = result.getString(2);
                String patientAddress = result.getString(3);
                int patientAge = result.getInt(4);
                String patientGender = result.getString(5);
                int patientWardNum = result.getInt(6);
                String admitDate = result.getString(7);
                System.out.println("Patient ID : " + patientID + " " + " " + "Patient Name : " + patientName + " " + "Patient Address : " + patientAddress + " " + "Patient Age : " + patientAge + " " + "Patient Gender : " + patientGender + " " + "Patient Ward Num : " + patientWardNum + " " + "admitDate : " + admitDate);

            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

    public void getWardWisePatient() {
        try {
            System.out.print("Enter Ward No to get details of Patient in that ward :  ");
            int pWnum = Sw1.nextInt();
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "SELECT * FROM patienttable WHERE patientWardNum ='" + pWnum + "'";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int patientID = result.getInt(1);
                String patientName = result.getString(2);
                String patientAddress = result.getString(3);
                int patientAge = result.getInt(4);
                String patientGender = result.getString(5);
                int patientWardNum = result.getInt(6);
                String admitDate = result.getString(7);
                System.out.println("Patient ID : " + patientID + " " + " " + "Patient Name : " + patientName + " " + "Patient Address : " + patientAddress + " " + "Patient Age : " + patientAge + " " + "Patient Gender : " + patientGender + " " + "Patient Ward Num : " + patientWardNum + " " + "admitDate : " + admitDate);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getDetailsofPatient() {

        System.out.println("Enter Patient ID to get details :  ");
        int pID = Sw1.nextInt();
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "SELECT * FROM patienttable WHERE patientID='" + pID + "'";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                int patientID = result.getInt(1);
                String patientName = result.getString(2);
                String patientAddress = result.getString(3);
                int patientAge = result.getInt(4);
                String patientGender = result.getString(5);
                int patientWardNum = result.getInt(6);
                String admitDate = result.getString(7);
                System.out.println("--------------------");
                System.out.println("Patient ID : " + patientID + " " + " " + "Patient Name : " + patientName + " " + "Patient Address : " + patientAddress + " " + "Patient Age : " + patientAge + " " + "Patient Gender : " + patientGender + " " + "Patient Ward Num : " + patientWardNum + " " + "admitDate : " + admitDate);
                System.out.println("--------------------");
            } else {
                System.out.println("No Patient with the Id you Enter");
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
