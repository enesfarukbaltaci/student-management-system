package org.example;

import java.util.HashMap;
import java.util.Map;

public class StudentService {
    private Map<String, Student> students;

    public StudentService() {
        this.students = new HashMap<>();
    }

    public boolean addStudent(String name) {
        if (students.containsKey(name)) {
            System.out.println("Error: Student with this name already exists.");
            return false;
        }
        students.put(name, new Student(name));
        System.out.println("Student " + name + " added successfully.");
        return true;
    }

    public boolean recordGrade(String name, String gradesInput) {
        Student student = students.get(name);
        if (student == null) {
            System.out.println("Error: Student not found.");
            return false;
        }

        try {
            // Split the input string by commas, trim spaces, and convert each to an integer
            String[] gradesArray = gradesInput.split(",");
            for (String gradeStr : gradesArray) {
                int grade = Integer.parseInt(gradeStr.trim());
                student.addGrade(grade);
            }
            System.out.println("Grades recorded for " + name);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid grade input. Please enter numbers only.");
            return false;
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students.values()) {
            System.out.println("Student: " + student.getName());
            System.out.println("Grades: " + student.getGrades());
            System.out.println("Average Grade: " + student.calculateAverageGrade());
            System.out.println();
        }
    }

    public void displayHighPerformingStudents(double threshold) {
        boolean found = false;
        for (Student student : students.values()) {
            if (student.calculateAverageGrade() > threshold) {
                System.out.println("Student: " + student.getName() + " - Average Grade: " + student.calculateAverageGrade());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students have an average grade above " + threshold);
        }
    }

}
