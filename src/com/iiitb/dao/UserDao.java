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

import com.iiitb.model.Student;
import com.mysql.jdbc.PreparedStatement;


public class UserDao
{
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "abhi";
	
	public boolean addUser(Student student)
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
		String sql = null;
		Statement stmt = null;
		PreparedStatement prepStmt = null;
		boolean result = false;
		int id = 0;
		
		try
		{
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select userId from sis_practice.user;");
			while(rs.next())
			{
				id = rs.getInt("userId");
			}
			id++;
			
			File file = new File(student.getImagePath());
			InputStream image = null;
			try
			{
				image = new FileInputStream(file);
			} catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			
			sqlUser = "insert into sis_practice.user(userId, name, rollNo, age, image, userType) values (?,?,?,?,?,?);";
			prepStmt = (PreparedStatement)con.prepareStatement(sqlUser);
			
			prepStmt.setInt(1, id);
			prepStmt.setString(2, student.getStudentName());
			prepStmt.setInt(3, student.getRollNo());
			prepStmt.setInt(4, student.getAge());
			prepStmt.setBlob(5, image);
			prepStmt.setString(6, "student");
			
			prepStmt.execute();
			/*if(result)
			{
				result = addToLogin(id, student);
				if(!result)
				{
					//remove
					StringBuilder sb = new StringBuilder();
					sb.append("delete from sis_practice.user where userId=");
					sb.append(id);
					sb.append(";");
					stmt.execute(sb.toString());
				}
			}*/
			
			addToLogin(id, student);
			
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
	
	private void addToLogin(int userId, Student student)
	{
		try
		{
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		Connection con = null;
		String sqlLogin = null;
		String sql = null;
		Statement stmt = null;
		PreparedStatement prepStmt = null;
		boolean result = false;
		int id = 0;

		try
		{
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select lId from sis_practice.login;");
			while (rs.next())
			{
				id = rs.getInt("lId");
			}
			id++;

			sqlLogin = "insert into sis_practice.login(lId, userFK, userName, password, accountType) values (?,?,?,?,?);";
			prepStmt = (PreparedStatement) con.prepareStatement(sqlLogin);

			prepStmt.setInt(1, id);
			prepStmt.setInt(2, userId);
			prepStmt.setString(3, student.getUserName());
			prepStmt.setString(4, student.getPassword());
			prepStmt.setString(5, "s");

			prepStmt.execute();

			// Clean-up environment
			stmt.close();
			con.close();
			prepStmt.close();

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<String> getStudentList()
	{
		List<String> studentList = new ArrayList<String>();
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
			ResultSet rs = stmt.executeQuery("select * from sis_practice.user where userType='student';");
			while(rs.next())
			{
				studentList.add(rs.getString("name"));
			}
			
			stmt.close();
			con.close();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return studentList;
	}
}
