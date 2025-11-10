package dao;

import db.DatabaseConnection;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS students (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "rollNo TEXT UNIQUE," +
                     "name TEXT," +
                     "phone TEXT," +
                     "department TEXT," +
                     "semester INTEGER" +
                     ");";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("✅ Student table ready");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student s) {
        String sql = "INSERT INTO students(rollNo, name, phone, department, semester) VALUES(?,?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, s.getRollNo());
            pstmt.setString(2, s.getName());
            pstmt.setString(3, s.getPhone());
            pstmt.setString(4, s.getDepartment());
            pstmt.setInt(5, s.getSemester());
            pstmt.executeUpdate();
            System.out.println("✅ Student added: " + s.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setRollNo(rs.getString("rollNo"));
                s.setName(rs.getString("name"));
                s.setPhone(rs.getString("phone"));
                s.setDepartment(rs.getString("department"));
                s.setSemester(rs.getInt("semester"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
