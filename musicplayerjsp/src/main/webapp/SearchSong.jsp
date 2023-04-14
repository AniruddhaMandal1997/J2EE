<%@page import="com.mysql.cj.result.IntegerValueFactory"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String sId = request.getParameter("id");
String songName = request.getParameter("songName");
String albumName = request.getParameter("albumName");
String singerName = request.getParameter("singerName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>

	<%!Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	String driver = "com.mysql.cj.jdbc.Driver";
	String dburl = "jdbc:mysql://localhost:3306/student";
	String password = "root";
	String user = "root";
	String queryById = "select * from song where songId = ?";
	String queryByAlbum = "select * from song where albumName = ?";
	String queryBySinger = "select * from song where singerName = ?";
	String queryBySong = "select * from song where songName = ? ";%>

	<h1 align="center">SEARCH SONG</h1>
	<div align="center"
		style="height: 350px; width: 870px; border: 3px solid; border-radius: 5px; margin: 0 auto; margin-top: 60px; display: flex; justify-content: space-around; align-items: center;">
		<div>
			<form action="./SearchSong.jsp" method="post">
				<div
					style="height: 300px; width: 400px; border: 2px solid gray; border-radius: 5px;">
					<table>
						<tr>
							<td>Enter Song ID</td>
							<td><input type="text" name="id"></td>
						</tr>
					</table>
					<h5>OR</h5>
					<table>
						<tr>
							<td>Enter Song Name</td>
							<td><input type="text" name="songName"></td>
						</tr>
					</table>
					<h5>OR</h5>
					<table>
						<tr>
							<td>Enter Song Album</td>
							<td><input type="text" name="albumName"></td>
						</tr>
					</table>
					<h5>OR</h5>
					<table>
						<tr>
							<td>Enter Singer Name</td>
							<td><input type="text" name="singerName"></td>
						</tr>
					</table>
				</div>
				<input type="submit" value="SEARCH">
			</form>
		</div>
		<div
			style="height: 300px; width: 400px; border: 2px solid gray; border-radius: 5px;">


			<%
			if (sId != null) {
				int id = Integer.parseInt(sId);
				Class.forName(driver);
				connection = DriverManager.getConnection(dburl, user, password);
				
				preparedStatement = connection.prepareStatement(queryById);
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
			%>
			<p>
				ID :
				<%=resultSet.getString(1)%>
				|| ALBUM :
				<%=resultSet.getString(2)%>
				|| SINGER :
				<%=resultSet.getString(3)%>
				|| DURATION
				<%=resultSet.getString(4)%>
				|| SONG :
				<%=resultSet.getString(5)%></p>
			<%
			}

			} %>

			<%
			if (singerName != null) {
			Class.forName(driver);
			connection = DriverManager.getConnection(dburl, user, password);
			
			preparedStatement = connection.prepareStatement(queryBySinger);
			preparedStatement.setString(1, singerName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			%>
			<p>
				ID :
				<%=resultSet.getString(1)%>
				|| ALBUM :
				<%=resultSet.getString(2)%>
				|| SINGER :
				<%=resultSet.getString(3)%>
				|| DURATION
				<%=resultSet.getString(4)%>
				|| SONG :
				<%=resultSet.getString(5)%></p>
			<%
			}
			}
			%>
			<%
			if (songName != null) {
			Class.forName(driver);
			connection = DriverManager.getConnection(dburl, user, password);
			
			preparedStatement = connection.prepareStatement(queryBySong);
			preparedStatement.setString(1, songName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			%>
			<p>
				ID :
				<%=resultSet.getString(1)%>
				|| ALBUM :
				<%=resultSet.getString(2)%>
				|| SINGER :
				<%=resultSet.getString(3)%>
				|| DURATION
				<%=resultSet.getString(4)%>
				|| SONG :
				<%=resultSet.getString(5)%></p>
			<%
			}
			}
			%>
			<%
			if (albumName != null) {
			Class.forName(driver);
			connection = DriverManager.getConnection(dburl, user, password);
			
			preparedStatement = connection.prepareStatement(queryByAlbum);
			preparedStatement.setString(1, albumName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			%>
			<p>
				ID :
				<%=resultSet.getString(1)%>
				|| ALBUM :
				<%=resultSet.getString(2)%>
				|| SINGER :
				<%=resultSet.getString(3)%>
				|| DURATION
				<%=resultSet.getString(4)%>
				|| SONG :
				<%=resultSet.getString(5)%></p>
			<%
			}
			}
			%>
			

		</div>
	</div>

	<div align="center" style="margin-top: 30px;">
		<a href="./Home.jsp"> <input style="" type="button" value="HOME">
		</a>
	</div>
</body>
</html>