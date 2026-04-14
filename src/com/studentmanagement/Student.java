
package com.studentmanagement;


public class Student {
   

    private int id;
    private String name;
    private int age;
    private String course;
    private int yearOfStudy;
    private double percentageMark;

    // Constructor
    public Student(int id, String name, int age, String course, int yearOfStudy, double percentageMark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.yearOfStudy = yearOfStudy;
        this.percentageMark = percentageMark;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public double getPercentageMark() {
        return percentageMark;
    }

    public void setPercentageMark(double percentageMark) {
        this.percentageMark = percentageMark;
    }

    // Display student details
    public void displayStudent() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("Year of Study: " + yearOfStudy);
        System.out.println("Percentage: " + percentageMark);
        System.out.println("--------------------------------");
    }
    // Inside Student.java (inside Student class)

// Convert a Student object to a CSV line
public String toCSV() {
    return id + "," + name + "," + age + "," + course + "," + yearOfStudy + "," + percentageMark;
}

// Create a Student object from a CSV line
public static Student fromCSV(String line) {
    String[] parts = line.split(",");
    int id = Integer.parseInt(parts[0]);
    String name = parts[1];
    int age = Integer.parseInt(parts[2]);
    String course = parts[3];
    int year = Integer.parseInt(parts[4]);
    double percentage = Double.parseDouble(parts[5]);
    return new Student(id, name, age, course, year, percentage);
}

}


