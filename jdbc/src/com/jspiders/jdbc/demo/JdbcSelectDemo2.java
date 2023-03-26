package com.jspiders.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelectDemo2 {
	public static void main(String[] args) {

		try {
			// 1. Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Open Connection
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/student?","root","root");

			// 3. Create Statement
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from song");

			// 4. Process the result
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " | " + resultSet.getString(2) + " | "
						+ resultSet.getString(3));
			}
			// 5 Close the connections
			connection.close();
			statement.close();
			resultSet.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
