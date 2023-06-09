/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.73
 * Generated at: 2023-03-26 19:00:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.mysql.cj.result.IntegerValueFactory;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class SearchSong_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	String driver = "com.mysql.cj.jdbc.Driver";
	String dburl = "jdbc:mysql://localhost:3306/student";
	String password = "root";
	String user = "root";
	String queryById = "select * from song where songId = ?";
	String queryByAlbum = "select * from song where albumName = ?";
	String queryBySinger = "select * from song where singerName = ?";
	String queryBySong = "select * from song where songName = ? ";
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.mysql.cj.result.IntegerValueFactory");
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
    _jspx_imports_classes.add("java.sql.DriverManager");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

String sId = request.getParameter("id");
String songName = request.getParameter("songName");
String albumName = request.getParameter("albumName");
String singerName = request.getParameter("singerName");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Search</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<h1 align=\"center\">SEARCH SONG</h1>\r\n");
      out.write("	<div align=\"center\"\r\n");
      out.write("		style=\"height: 350px; width: 870px; border: 3px solid; border-radius: 5px; margin: 0 auto; margin-top: 60px; display: flex; justify-content: space-around; align-items: center;\">\r\n");
      out.write("		<div>\r\n");
      out.write("			<form action=\"./SearchSong.jsp\" method=\"post\">\r\n");
      out.write("				<div\r\n");
      out.write("					style=\"height: 300px; width: 400px; border: 2px solid gray; border-radius: 5px;\">\r\n");
      out.write("					<table>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td>Enter Song ID</td>\r\n");
      out.write("							<td><input type=\"text\" name=\"id\"></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</table>\r\n");
      out.write("					<h5>OR</h5>\r\n");
      out.write("					<table>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td>Enter Song Name</td>\r\n");
      out.write("							<td><input type=\"text\" name=\"songName\"></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</table>\r\n");
      out.write("					<h5>OR</h5>\r\n");
      out.write("					<table>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td>Enter Song Album</td>\r\n");
      out.write("							<td><input type=\"text\" name=\"albumName\"></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</table>\r\n");
      out.write("					<h5>OR</h5>\r\n");
      out.write("					<table>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td>Enter Singer Name</td>\r\n");
      out.write("							<td><input type=\"text\" name=\"singerName\"></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</table>\r\n");
      out.write("				</div>\r\n");
      out.write("				<input type=\"submit\" value=\"SEARCH\">\r\n");
      out.write("			</form>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div\r\n");
      out.write("			style=\"height: 300px; width: 400px; border: 2px solid gray; border-radius: 5px;\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			");

			if (sId != null) {
				int id = Integer.parseInt(sId);
				Class.forName(driver);
				connection = DriverManager.getConnection(dburl, user, password);
				
				preparedStatement = connection.prepareStatement(queryById);
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
			
      out.write("\r\n");
      out.write("			<p>\r\n");
      out.write("				ID :\r\n");
      out.write("				");
      out.print(resultSet.getString(1));
      out.write("\r\n");
      out.write("				|| ALBUM :\r\n");
      out.write("				");
      out.print(resultSet.getString(2));
      out.write("\r\n");
      out.write("				|| SINGER :\r\n");
      out.write("				");
      out.print(resultSet.getString(3));
      out.write("\r\n");
      out.write("				|| DURATION\r\n");
      out.write("				");
      out.print(resultSet.getString(4));
      out.write("\r\n");
      out.write("				|| SONG :\r\n");
      out.write("				");
      out.print(resultSet.getString(5));
      out.write("</p>\r\n");
      out.write("			");

			}

			} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("			");

			if (singerName != null) {
			Class.forName(driver);
			connection = DriverManager.getConnection(dburl, user, password);
			
			preparedStatement = connection.prepareStatement(queryBySinger);
			preparedStatement.setString(1, singerName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			
      out.write("\r\n");
      out.write("			<p>\r\n");
      out.write("				ID :\r\n");
      out.write("				");
      out.print(resultSet.getString(1));
      out.write("\r\n");
      out.write("				|| ALBUM :\r\n");
      out.write("				");
      out.print(resultSet.getString(2));
      out.write("\r\n");
      out.write("				|| SINGER :\r\n");
      out.write("				");
      out.print(resultSet.getString(3));
      out.write("\r\n");
      out.write("				|| DURATION\r\n");
      out.write("				");
      out.print(resultSet.getString(4));
      out.write("\r\n");
      out.write("				|| SONG :\r\n");
      out.write("				");
      out.print(resultSet.getString(5));
      out.write("</p>\r\n");
      out.write("			");

			}
			}
			
      out.write("\r\n");
      out.write("			");

			if (songName != null) {
			Class.forName(driver);
			connection = DriverManager.getConnection(dburl, user, password);
			
			preparedStatement = connection.prepareStatement(queryBySong);
			preparedStatement.setString(1, songName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			
      out.write("\r\n");
      out.write("			<p>\r\n");
      out.write("				ID :\r\n");
      out.write("				");
      out.print(resultSet.getString(1));
      out.write("\r\n");
      out.write("				|| ALBUM :\r\n");
      out.write("				");
      out.print(resultSet.getString(2));
      out.write("\r\n");
      out.write("				|| SINGER :\r\n");
      out.write("				");
      out.print(resultSet.getString(3));
      out.write("\r\n");
      out.write("				|| DURATION\r\n");
      out.write("				");
      out.print(resultSet.getString(4));
      out.write("\r\n");
      out.write("				|| SONG :\r\n");
      out.write("				");
      out.print(resultSet.getString(5));
      out.write("</p>\r\n");
      out.write("			");

			}
			}
			
      out.write("\r\n");
      out.write("			");

			if (albumName != null) {
			Class.forName(driver);
			connection = DriverManager.getConnection(dburl, user, password);
			
			preparedStatement = connection.prepareStatement(queryByAlbum);
			preparedStatement.setString(1, albumName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			
      out.write("\r\n");
      out.write("			<p>\r\n");
      out.write("				ID :\r\n");
      out.write("				");
      out.print(resultSet.getString(1));
      out.write("\r\n");
      out.write("				|| ALBUM :\r\n");
      out.write("				");
      out.print(resultSet.getString(2));
      out.write("\r\n");
      out.write("				|| SINGER :\r\n");
      out.write("				");
      out.print(resultSet.getString(3));
      out.write("\r\n");
      out.write("				|| DURATION\r\n");
      out.write("				");
      out.print(resultSet.getString(4));
      out.write("\r\n");
      out.write("				|| SONG :\r\n");
      out.write("				");
      out.print(resultSet.getString(5));
      out.write("</p>\r\n");
      out.write("			");

			}
			}
			
      out.write("\r\n");
      out.write("			\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<div align=\"center\" style=\"margin-top: 30px;\">\r\n");
      out.write("		<a href=\"./Home.jsp\"> <input style=\"\" type=\"button\" value=\"HOME\">\r\n");
      out.write("		</a>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
