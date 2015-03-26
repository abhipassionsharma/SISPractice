package com.iiitb.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iiitb.model.CourseInfo;
import com.mysql.jdbc.PreparedStatement;

public class CourseDao
{
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost:3306/test";

		// Database credentials
		static final String USER = "root";
		static final String PASS = "abhi";
		
	public boolean addCourse(CourseInfo course)
	{
		try
		{
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		Connection con = null;
		String sql = null;
		String sqlCourse = null;
		Statement stmt = null;
		PreparedStatement prepStmt = null;
		boolean result = false;
		int id = 0;
		
		try
		{
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select cId from sis_practice.course;");
			while(rs.next())
			{
				id = rs.getInt("cId");
			}
			id++;
			
			sqlCourse = "insert into sis_practice.course(cId, courseName, courseId, faculty, semester) values (?,?,?,?,?);";
			prepStmt = (PreparedStatement)con.prepareStatement(sqlCourse);
			
			prepStmt.setInt(1, id);
			prepStmt.setString(2, course.getCourseName());
			prepStmt.setInt(3, course.getCourseId());
			prepStmt.setString(4, course.getFaculty());
			prepStmt.setInt(5, course.getSemester());
			
			prepStmt.execute();
			
			// Clean-up environment
			stmt.close();
			con.close();
			prepStmt.close();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
	public List<String> getFacultyList()
	{
		List<String> facultyList = new ArrayList<String>();
		try
		{
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		Connection con = null;
		String sql = null;
		Statement stmt = null;
		
		try
		{
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from sis_practice.faculty;");
			while(rs.next())
			{
				facultyList.add(rs.getString("facultyName"));
			}
			
			stmt.close();
			con.close();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return facultyList;
	}
	
	public List<String> getCourseList()
	{
		List<String> courseList = new ArrayList<String>();
		try
		{
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		Connection con = null;
		String sql = null;
		Statement stmt = null;
		
		try
		{
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from sis_practice.course;");
			while(rs.next())
			{
				courseList.add(rs.getString("courseName"));
			}
			
			stmt.close();
			con.close();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return courseList;
	}
}
