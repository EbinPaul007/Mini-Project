package com.project.pack;
import java.sql.*;
import java.util.Scanner;

public class Admin {
    Scanner S1 = new Scanner(System.in);
    Scanner S2 = new Scanner(System.in);
    Patient p2 = new Patient();
    String jdbcURL = "jdbc:mysql://localhost:3306/patientdb";
    String username = "root";
    String password = "projects@123";

    public void addPatient() { // Method to Insert a Patient details


        System.out.print("Enter Patient ID :  ");
        p2.patientID = S1.nextInt();
        System.out.print("Enter Patient Name : ");
        p2.patientName = S2.nextLine();
        System.out.print("Enter Patient Address : ");
        p2.patientAddress = S2.nextLine();
        System.out.print("Enter Patient Age :  ");
        p2.patientAge = S1.nextInt();
        System.out.print("Enter Patient Gender :  ");
        p2.patientGender = S2.nextLine();
        System.out.print("Enter Ward No :  ");
        p2.patientWardNum = S1.nextInt();
        System.out.print("Enter Admit Date :  ");
        p2.admitDate = S2.nextLine();
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "INSERT INTO patienttable (patientID,patientName,patientAddress,patientAge,patientGender,patientWardNum,admitDate)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, p2.patientID);
            statement.setString(2, p2.patientName);
            statement.setString(3, p2.patientAddress);
            statement.setInt(4, p2.patientAge);
            statement.setString(5, p2.patientGender);
            statement.setInt(6, p2.patientWardNum);
            statement.setString(7, p2.admitDate);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A new patient inserted");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void removeRecoveredPatients() {//Method to remove a recovered Patient
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "delete  from patienttable where patientName=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.println("Enter Patient Name to Remove :  ");
            String rpName = S2.nextLine();
            statement.setString(1,rpName);
            int rows = statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


        public void updatePatientDetails() {//Method to update a Patient details

            System.out.println("Enter the Patient ID you want to update ");
            int Id=S1.nextInt();
            System.out.println("Enter new Name : ");
            String uName=S2.nextLine();
            System.out.println("Enter new Address : ");
            String uAddress=S2.nextLine();
            System.out.println("Enter new Age : ");
            int uAge=S1.nextInt();
            System.out.println("Enter new Gender : ");
            String uGender=S2.nextLine();
            System.out.println("Enter new Ward Num  : ");
            int uWardNum=S1.nextInt();
            System.out.println("Enter new Admit Date : ");
            String uAdmitDate=S2.nextLine();
            try{
                Connection connection = DriverManager.getConnection(jdbcURL, username, password);
                String sql = " update patienttable set patientName=?,patientAddress=?,patientAge=?,patientGender=?,patientWardNum=?,admitDate=? where patientID = '"+Id+"'";

                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, uName);
                statement.setString(2,uAddress);
                statement.setInt(3, uAge);
                statement.setString(4,uGender);
                statement.setInt(5, uWardNum);
                statement.setString(6, uAdmitDate);

                int rows = statement.executeUpdate();



                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    }



}




