<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
String songName = request.getParameter("songName");
String songDuration = request.getParameter("duration");
String singerName = request.getParameter("singerName");
String songAlbum = request.getParameter("album");
String refresh = request.getParameter("refresh");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Song</title>
</head>
<body>

	<%!Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	int result;
	String dburl = "jdbc:mysql://localhost:3306/student";
	String driver = "com.mysql.cj.jdbc.Driver";
	String user = "root";
	String password = "root";
	String query = "insert into song values (?,?,?,?,?)";%>

	<h2 align="center" style="margin-top: 50px;">ADD SONG TO DATABASE</h2>
	<div
		style="height: 350px; width: 870px; border: 1px solid; border-radius: 5px; margin: 0 auto; display: flex; justify-content: space-around; align-items: center;">
		<div align="center"
			style="height: 300px; width: 400px; border: 2px solid rgb(142, 142, 142); border-radius: 3px;">
			<form action="./AddSong.jsp" method="post">
				<table style="margin-top: 40px; border: 1.5px solid;"
					cellpadding="5">
					<tr>
						<td>ID</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>Song Name</td>
						<td><input type="text" name="songName"></td>
					</tr>
					<tr>
						<td>Duration</td>
						<td><input type="text" name="duration"></td>
					</tr>
					<tr>
						<td>Singer Name</td>
						<td><input type="text" name="singerName"></td>
					</tr>
					<tr>
						<td>Album</td>
						<td><input type="text" name="album"></td>
					</tr>
				</table>
				<input type="submit" value="ADD" style="margin-top: 10px;">
			</form>
			<%
			if (id != null && singerName != null && songAlbum != null && songDuration != null && songName != null) {
				Class.forName(driver);
				connection = DriverManager.getConnection(dburl, user, password);
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, id);
				preparedStatement.setString(2, songAlbum);
				preparedStatement.setString(3, singerName);
				preparedStatement.setString(4, songDuration);
				preparedStatement.setString(5, songName);
				result = preparedStatement.executeUpdate();
			}
			%>
			<%
			if (result != 0) {
			%>
			<h3>
				<%=result%>
				Song Added to the Database
			</h3>
			<%
			}
			%>
		</div>

		<div
			style="height: 300px; width: 400px; border: 1px solid; border-radius: 3px;">
			<%
			Class.forName(driver);
			connection = DriverManager.getConnection(dburl, user, password);
			preparedStatement = connection.prepareStatement("select * from song");
			resultSet = preparedStatement.executeQuery();
			%>
			<form action="./AddSong.jsp" method="post">
				<input type="submit" value="Refresh" name="refresh">
			</form>
			<h5>ID &nbsp &nbsp &nbsp &nbsp ALBUM &nbsp &nbsp &nbsp &nbsp
				SINGER &nbsp &nbsp &nbsp &nbsp DURATION &nbsp &nbsp &nbsp &nbsp SONG</h5>
			<%
			while (resultSet != null && resultSet.next()) {
			%>
			<h5>
				<%=resultSet.getString(1)%>
				&nbsp &nbsp &nbsp &nbsp
				<%=resultSet.getString(2)%>&nbsp &nbsp &nbsp &nbsp<%=resultSet.getString(3)%>&nbsp
				&nbsp &nbsp &nbsp<%=resultSet.getString(4)%>&nbsp &nbsp &nbsp &nbsp<%=resultSet.getString(5)%></h5>
			<%
			}
			%>
		</div>
	</div>
	<div align="center" style="margin-top: 30px;">
	<a  href="./Home.jsp"> <input style="" type="button" value="HOME"> </a>
	</div>
	


</body>
</html>