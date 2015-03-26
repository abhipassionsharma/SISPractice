package com.iiitb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class LoginDao
{
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/sis_practice";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "abhi";

	public boolean checkLoginStatus(String userName, String pwd)
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
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String password = null;

		try
		{
			con = DriverManager.getConnection(DB_URL, USER, PASS);

			sql = "select * from sis_practice.login where userName=?";

			preparedStatement = (PreparedStatement) con.prepareStatement(sql);

			preparedStatement.setString(1, userName);
			System.out.println(preparedStatement);

			rs = preparedStatement.executeQuery();

			while (rs.next())
			{
				// Retrieve by column name
				password = rs.getString("password");
			}

			// Clean-up environment
			rs.close();
			con.close();
			preparedStatement.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		if (pwd.equals(password))
			return true;
		else
			return false;

	}
}
