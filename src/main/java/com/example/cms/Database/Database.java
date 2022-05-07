package com.example.cms.Database;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Database {
    ArrayList<UserInformation> usersInformation = new ArrayList<>();

    public void getUserInformation() throws IOException, ClassNotFoundException {
        try {
            Connection con;
            PreparedStatement ps;
            ResultSet rs;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1w3r5y7i9");
            ps = con.prepareStatement("SELECT * FROM users");
            rs = ps.executeQuery();

            while (rs.next()) {
                int user_id = rs.getInt("UserId");
                String fio = rs.getString("FIO");
                String telefon = rs.getString("Telefon");
                String fani = rs.getString("Fani");
                String guruhi = rs.getString("Guruhi");

                usersInformation.add(new UserInformation(user_id, fio, telefon, fani, guruhi));
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<UserInformation> getUsersInformation () {
        return usersInformation;
    }

    ArrayList<AdminInformation> adminsInformation = new ArrayList<>();

    public void getAdminInformation() throws IOException, ClassNotFoundException {
        try {
            Connection con;
            PreparedStatement ps;
            ResultSet rs;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1w3r5y7i9");

            ps = con.prepareStatement("SELECT * FROM admins");
            rs = ps.executeQuery();

            while (rs.next()) {
                int admin_id = rs.getInt("AdminId");
                String fio = rs.getString("fio");
                String telefon = rs.getString("Telefon");
                String username = rs.getString("username");
                String parol = rs.getString("parol");

                adminsInformation.add(new AdminInformation(admin_id, fio, telefon, username, parol));
            }
            rs.close();

        } catch(SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<AdminInformation> getAdminsInformation() {
        return adminsInformation;
    }

    ArrayList<TeacherInformation> teachersInformation = new ArrayList<>();

    public void getTeacherInformation() throws IOException, ClassNotFoundException {
        try {
            Connection con;
            PreparedStatement ps;
            ResultSet rs;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1w3r5y7i9");

            ps = con.prepareStatement("SELECT * FROM teachers");
            rs = ps.executeQuery();

            while (rs.next()) {
                int teacher_id = rs.getInt("TeacherId");
                String fio = rs.getString("FIO");
                String telefon = rs.getString("Telefon");
                String fani = rs.getString("Fani");
                String guruhi = rs.getString("Guruhi");
                String username = rs.getString("username");
                String parol = rs.getString("parol");

                teachersInformation.add(new TeacherInformation(teacher_id, fio, telefon, fani, guruhi, username, parol));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<TeacherInformation> getTeachersInformation() {
        return teachersInformation;
    }

    ArrayList<CourseInformation> coursesInformation = new ArrayList<>();
    public void getCourseInformation() throws IOException, ClassNotFoundException {
        try {
            Connection con;
            PreparedStatement ps;
            ResultSet rs;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1w3r5y7i9");

            ps = con.prepareStatement("SELECT * FROM courses");
            rs = ps.executeQuery();

            while (rs.next()) {
                int course_id = rs.getInt("courseId");
                String nomi = rs.getString("Nomi");
                String davomiyligi = rs.getString("Davomiyligi");
                String oqituvchi = rs.getString("Oqituvchi");
                String narxi = rs.getString("Narxi");

                coursesInformation.add(new CourseInformation(course_id, nomi, davomiyligi, oqituvchi, narxi));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<CourseInformation> getCoursesInformation() {
        return coursesInformation;
    }


    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1w3r5y7i9");
        return conn;
    }
 }
