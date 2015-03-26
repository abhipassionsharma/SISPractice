package com.iiitb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class GradesDao
{
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	
	// Database credentials
	static final String USER = "root";
	static final String PASS = "abhi";
	
	public boolean assignGrades(String studentName, String courseName, String grade)
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
		Statement stmt = null;
		PreparedStatement prepStmt = null;
		int id = 0;
		
		try
		{
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select gId from sis_practice.grade;");
			while(rs.next())
			{
				id = rs.getInt("gId");
			}
			id++;
			
			sql = "insert into sis_practice.grade(gId, studentFK, courseFK, grade) values (?,?,?,?);";
			prepStmt = (PreparedStatement)con.prepareStatement(sql);
			
			prepStmt.setInt(1, id);
			prepStmt.setInt(2, getId(studentName, 1));
			prepStmt.setInt(3, getId(courseName, 0));
			prepStmt.setString(4, grade);
			
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
	
	private int getId(String name, int flag)
	{
		try
		{
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		Connection con = null;
		String sqlUser = null;
		String sqlCourse = null;
		PreparedStatement prepStmt = null;
		int id = 0;
		
		try
		{
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			if(flag == 1)
			{
				sqlUser = "select userId from sis_practice.user where name=?";
				prepStmt = (PreparedStatement)con.prepareStatement(sqlUser);
			}
			else
			{
				sqlCourse = "select cId from sis_practice.course where courseName=?";
				prepStmt = (PreparedStatement)con.prepareStatement(sqlCourse);
			}
			prepStmt.setString(1, name);
			ResultSet rs = prepStmt.executeQuery();
			
			while(rs.next())
			{
				id = rs.getInt(1);
			}
			
			// Clean-up environment
			con.close();
			prepStmt.close();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return id;
	}
	
}