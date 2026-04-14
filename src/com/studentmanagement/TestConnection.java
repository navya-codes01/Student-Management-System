package com.studentmanagement;
import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {
 Student s = new Student(0, "Navya", 20, "BSc CS", 2, 85.5);

        StudentDAO dao = new StudentDAO();
        dao.addStudent(s);
    }
}