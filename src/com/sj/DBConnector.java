package com.sj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
Connection conn;
public Connection getConn() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schemaone/root");
		return conn;
	}
	catch(ClassNotFoundException e) {
		e.printStackTrace();
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
return conn;

}
}
