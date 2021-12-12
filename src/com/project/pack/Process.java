package com.project.pack;
import java.util.*;

public class Process {
    public static void main(String[] args)  {
        Admin a= new Admin();
        User u = new User();
        int m;
        do{
            int choice;

            Scanner s = new Scanner(System.in);
            Scanner s1 = new Scanner(System.in);
            System.out.println("**********************************" +"\nACD PANCHAYTH COVID PATIENTS DIRECTORY \n**************************************");
            System.out.println("1.Insert Patient Detail");
            System.out.println("2.Display a Patient Detail");
            System.out.println("3.Search for a Patient Detail");
            System.out.println("4.Remove a Recoverd Patient");
            System.out.println("5.Update Patient details ");
            System.out.println("6.Get Patients in specific ward");
            System.out.print("Enter your Choice:  ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    a.addPatient();
                    System.out.println("Patient Registered Successfully !!!");
                    u.showAllPatientDetails();
                    break;

                case 2:
                   u.showAllPatientDetails();
                    break;
                case 3:
                    u.getDetailsofPatient();
                    break;
                case 4:
                   a.removeRecoveredPatients();
                    u.showAllPatientDetails();
                    break;
                case 5:
                    a.updatePatientDetails();
                    break;
                case 6:
                    u.getWardWisePatient();
                    break;
                default:
                    System.out.println("Wrong choice Try again..............");
                    break;}

            System.out.println("Do you want to continue selecting options (1/0):");
            m = s.nextInt();
        } while(m == 1);


        }
    }


