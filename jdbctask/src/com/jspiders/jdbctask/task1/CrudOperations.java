package com.jspiders.jdbctask.task1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class CrudOperations {

	private static Connection connection;
	private static Statement statement;
	private static FileReader fileReader;
	private static Properties properties;
	private static ResultSet resultSet;
	private static int result;
	private static String filePath = "D:\\JAVA\\WEJA1\\jdbctask\\src\\resource\\db_info.properties";
	private static Scanner scanner;

	
	public static void main(String[] args) {

		try {
			scanner = new Scanner(System.in);

			fileReader = new FileReader(filePath);
			properties = new Properties();
			properties.load(fileReader);

			Class.forName(properties.getProperty("driverPath"));

			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);
			statement = connection.createStatement();

			boolean loop = true;
			while (loop) {
				System.out.println("__________ SELECT OPERATION (EMP TABLE) ____________");
				System.out.println("1. Show Table\n" + "2. Insert data to database\n" + "3. Update data of database\n"
						+ "4. Delete data from database\n" + "5. Delete all data from databse\n" + "6. Exit");
				int choose = scanner.nextInt();
				switch (choose) {
				case 1: {
					// display table
					resultSet = statement.executeQuery(properties.getProperty("display"));
					while (resultSet.next()) {
						System.out.println(resultSet.getString(1) + " || " + resultSet.getString(2) + " || "
								+ resultSet.getString(3) + " || " + resultSet.getString(4));
					}
					break;
				}
				case 2: {
					// INSERTING DATA INTO DATABASE

					System.out.println("---- ENTER VALUES TO INSERT INTO DATABASE ------");
					System.out.println("(int)EMPID");
					int EMPID = scanner.nextInt();
					System.out.println("(String)ENAME");
					String ENAME = scanner.next();
					System.out.println("(long)SAL");
					int SAL = scanner.nextInt();
					System.out.println("(String)JOB");
					String JOB = scanner.next();
					result = statement.executeUpdate(
							"insert into emp values (" + EMPID + " , '" + ENAME + "' , " + SAL + " , '" + JOB + "' )");
					System.out.println("Query OK. " + result + " row(s) affected");

					// display table
					resultSet = statement.executeQuery(properties.getProperty("display"));
					while (resultSet.next()) {
						System.out.println(resultSet.getString(1) + " || " + resultSet.getString(2) + " || "
								+ resultSet.getString(3) + " || " + resultSet.getString(4));
					}

					break;
				}
				case 3: {
					// UPDATING DATA
					System.out.println("-------- ENTER VALUES TO UPDATE ---------");
					System.out.println("1. Update ID\n" + "2. Update ENAME\n" + "3. Update SAL\n" + "4. Update JOB");
					int choose1 = scanner.nextInt();
					switch (choose1) {
					case 1: {
						System.out.println("Enter emp_ID and new_ID");
						int empId = scanner.nextInt();
						int newId = scanner.nextInt();
						result = statement.executeUpdate("update emp set EMPID = " + newId + " where EMPID = " + empId);
						break;
					}
					case 2: {
						System.out.println("Enter emp_ID and new_NAME");
						String empId = scanner.next();
						String newEname = scanner.next();
						result = statement
								.executeUpdate("update emp set ENAME = '" + newEname + "' where EMPID = " + empId);
						break;
					}
					case 3: {
						System.out.println("Enter emp_ID and new_SALARY");
						long empId = scanner.nextLong();
						long newSal = scanner.nextLong();
						result = statement.executeUpdate("update emp set SAL = " + newSal + " where EMPID = " + empId);
						break;
					}
					case 4: {
						System.out.println("Enter emp_ID and new_JOB");
						String empId = scanner.next();
						String newJob = scanner.next();
						result = statement
								.executeUpdate("update emp set JOB = '" + newJob + "' where EMPID = " + empId);
						break;
					}
					}
					// display query effect on database
					System.out.println("Query OK. " + result + " row(s) affected");
					// display table
					resultSet = statement.executeQuery(properties.getProperty("display"));
					while (resultSet.next()) {
						System.out.println(resultSet.getString(1) + " || " + resultSet.getString(2) + " || "
								+ resultSet.getString(3) + " || " + resultSet.getString(4));
					}
					break;
				}
				case 4: {
					System.out.println("------- Enter EMPID to delete data -------");
					int deleteRow = scanner.nextInt();
					result = statement.executeUpdate("delete from emp where EMPID = " + deleteRow);

					// display query effect on database
					System.out.println("Query OK. " + result + " row(s) affected");
					// display table
					resultSet = statement.executeQuery(properties.getProperty("display"));
					while (resultSet.next()) {
						System.out.println(resultSet.getString(1) + " || " + resultSet.getString(2) + " || "
								+ resultSet.getString(3) + " || " + resultSet.getString(4));
					}
					break;
				}
				case 5: {
					result = statement.executeUpdate(properties.getProperty("deleteAll"));
					// display query effect on database
					System.out.println("Query OK. " + result + " row(s) affected");
					break;
				}
				case 6: {
					loop = false;
				}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
				if (resultSet !=null) {
					resultSet.close();
				}
				if (fileReader !=null) {
					fileReader.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
