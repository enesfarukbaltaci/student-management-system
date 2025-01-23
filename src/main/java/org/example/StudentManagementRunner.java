package org.example;

import java.util.Scanner;

public class StudentManagementRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Record Grade");
            System.out.println("3. Display All Students");
            System.out.println("4. Display High-Performing Students");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // dummy

            switch (option) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    studentService.addStudent(name);
                    break;

                case 2:
                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    String gradesInput = scanner.nextLine();
                    studentService.recordGrade(name, gradesInput);
                    break;

                case 3:
                    studentService.displayAllStudents();
                    break;

                case 4:
                    System.out.print("Enter grade threshold: ");
                    double threshold = scanner.nextDouble();
                    studentService.displayHighPerformingStudents(threshold);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

    }
}
