package com.studentmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.*;

public class StudentDAO {

    public void addStudent(Student s) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO students(name, age, course, year_of_study, percentage) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getYearOfStudy());
            ps.setDouble(5, s.getPercentageMark());

            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    public List<Student> getAllStudents() {
    List<Student> list = new ArrayList<>();

    try {
        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM students";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            Student s = new Student(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getString("course"),
                rs.getInt("year_of_study"),
                rs.getDouble("percentage")
            );
            list.add(s);
        }

    } catch (Exception e) {
        System.out.println(e);
    }

    return list;
}





}