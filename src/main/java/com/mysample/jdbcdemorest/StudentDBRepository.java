package com.mysample.jdbcdemorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDBRepository {
	
	Connection conn = null;

	public StudentDBRepository() {
		
		String URL = "jdbc:mysql://localhost:3306/my_test_schema";
		String username = "root";
		String password = "root";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(URL, username, password);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createStudent(Student stud) {
		String sql = "insert into student_data values (?,?,?,?,?,?)";
		try {
			PreparedStatement prepStat = conn.prepareStatement(sql);
			prepStat.setInt(1, stud.getId());
			prepStat.setString(2, stud.getName());
			prepStat.setString(3, stud.getDob());
			prepStat.setString(4, stud.getStd());
			prepStat.setString(5, stud.getSubject());
			prepStat.setInt(6, stud.getMark());
			prepStat.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Student getStudent(int id) {
		String sql = "select * from student_data where id=" + id;
		Student stud = new Student();
		Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				stud.setId(rs.getInt(1));
				stud.setName(rs.getString(2));
				stud.setDob(rs.getString(3));
				stud.setStd(rs.getString(4));
				stud.setSubject(rs.getString(5));
				stud.setMark(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stud;
	}
	
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		String sql = "select * from student_data";
		Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				Student stud = new Student();
				stud.setId(rs.getInt(1));
				stud.setName(rs.getString(2));
				stud.setDob(rs.getString(3));
				stud.setStd(rs.getString(4));
				stud.setSubject(rs.getString(5));
				stud.setMark(rs.getInt(6));
				students.add(stud);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	
	public void updateStudent(Student stud) {
		String sql = "update student_data set name=?, dob=? , std=?, subject=?, mark=? where id=?";
		try {
			PreparedStatement prepStat = conn.prepareStatement(sql);
			prepStat.setString(1, stud.getName());
			prepStat.setString(2, stud.getDob());
			prepStat.setString(3, stud.getStd());
			prepStat.setString(4, stud.getSubject());
			prepStat.setInt(5, stud.getMark());
			prepStat.setInt(6, stud.getId());
			prepStat.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(int id) {
		String sql = "delete from student_data where id=?";
		try {
			PreparedStatement prepStat = conn.prepareStatement(sql);
			prepStat.setInt(1, id);
			prepStat.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}