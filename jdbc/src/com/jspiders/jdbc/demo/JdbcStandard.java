package com.jspiders.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStandard {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String dbUrl = "jdbc:mysql://localhost:3306/student";
	private static String user = "root";
	private static String password = "root";
	private static String query;

	public static void main(String[] args) {

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(dbUrl, user, password);
			statement = connection.createStatement();

			query = "select * from student";
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				System.out.println(
						resultSet.getString(1) + " | " + resultSet.getString(2) + " | " + resultSet.getString(3));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		

	}

}
