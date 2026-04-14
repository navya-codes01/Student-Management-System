package com.studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        // Load students from file
        File file = new File("students.txt");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    students.add(Student.fromCSV(line));
                }
            } catch (IOException e) {
                System.out.println("Error loading students: " + e.getMessage());
            }
        }

        int choice;
        do {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) { // input validation
                System.out.println("Invalid choice! Please enter a number.");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                // Add Student
                case 1:
                    System.out.println("\n--- Add Student ---");

                    int id;
                    while (true) {
                        System.out.print("Enter ID: ");
                        if (sc.hasNextInt()) {
                            id = sc.nextInt();
                            sc.nextLine();
                            break;
                        } else {
                            System.out.println("Invalid ID! Enter a number.");
                            sc.nextLine();
                        }
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    int age;
                    while (true) {
                        System.out.print("Enter Age: ");
                        if (sc.hasNextInt()) {
                            age = sc.nextInt();
                            sc.nextLine();
                            break;
                        } else {
                            System.out.println("Invalid Age! Enter a number.");
                            sc.nextLine();
                        }
                    }

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    int year;
                    while (true) {
                        System.out.print("Enter Year of Study: ");
                        if (sc.hasNextInt()) {
                            year = sc.nextInt();
                            sc.nextLine();
                            break;
                        } else {
                            System.out.println("Invalid Year! Enter a number.");
                            sc.nextLine();
                        }
                    }

                    double percentage;
                    while (true) {
                        System.out.print("Enter Percentage: ");
                        if (sc.hasNextDouble()) {
                            percentage = sc.nextDouble();
                            sc.nextLine();
                            break;
                        } else {
                            System.out.println("Invalid Percentage! Enter a number.");
                            sc.nextLine();
                        }
                    }

                    Student student = new Student(id, name, age, course, year, percentage);
                    students.add(student);
                    saveToFile(students);
                    System.out.println("✔ Student added successfully!");
                    break;

                // View All Students
                case 2:
                    System.out.println("\n--- View All Students ---");
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : students) {
                            s.displayStudent();
                        }
                    }
                    break;

                // Search Student by ID
                case 3:
                    System.out.println("\n--- Search Student ---");
                    System.out.print("Enter Student ID to search: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid ID! Enter a number.");
                        sc.next();
                    }
                    int searchId = sc.nextInt();
                    sc.nextLine();

                    boolean found = false;
                    for (Student s : students) {
                        if (s.getId() == searchId) {
                            s.displayStudent();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;

                // Update Student
                case 4:
                    System.out.println("\n--- Update Student ---");
                    System.out.print("Enter Student ID to update: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid ID! Enter a number.");
                        sc.next();
                    }
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    boolean updated = false;
                    for (Student s : students) {
                        if (s.getId() == updateId) {
                            System.out.print("Enter new Name: ");
                            s.setName(sc.nextLine());

                            int newAge;
                            while (true) {
                                System.out.print("Enter new Age: ");
                                if (sc.hasNextInt()) {
                                    newAge = sc.nextInt();
                                    sc.nextLine();
                                    break;
                                } else {
                                    System.out.println("Invalid Age! Enter a number.");
                                    sc.nextLine();
                                }
                            }
                            s.setAge(newAge);

                            System.out.print("Enter new Course: ");
                            s.setCourse(sc.nextLine());

                            int newYear;
                            while (true) {
                                System.out.print("Enter new Year of Study: ");
                                if (sc.hasNextInt()) {
                                    newYear = sc.nextInt();
                                    sc.nextLine();
                                    break;
                                } else {
                                    System.out.println("Invalid Year! Enter a number.");
                                    sc.nextLine();
                                }
                            }
                            s.setYearOfStudy(newYear);

                            double newPercentage;
                            while (true) {
                                System.out.print("Enter new Percentage: ");
                                if (sc.hasNextDouble()) {
                                    newPercentage = sc.nextDouble();
                                    sc.nextLine();
                                    break;
                                } else {
                                    System.out.println("Invalid Percentage! Enter a number.");
                                    sc.nextLine();
                                }
                            }
                            s.setPercentageMark(newPercentage);

                            saveToFile(students);
                            System.out.println("✔ Student updated successfully!");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("Student with ID " + updateId + " not found.");
                    }
                    break;

                // Delete Student
                case 5:
                    System.out.println("\n--- Delete Student ---");
                    System.out.print("Enter Student ID to delete: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid ID! Enter a number.");
                        sc.next();
                    }
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    boolean removed = false;
                    for (Student s : students) {
                        if (s.getId() == deleteId) {
                            students.remove(s);
                            saveToFile(students);
                            System.out.println("✔ Student deleted successfully!");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Student with ID " + deleteId + " not found.");
                    }
                    break;

                // Exit
                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1-6.");
            }

        } while (choice != 6);

        sc.close();
    }

    // Method to save students to file
    public static void saveToFile(ArrayList<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student s : students) {
                bw.write(s.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }
}
