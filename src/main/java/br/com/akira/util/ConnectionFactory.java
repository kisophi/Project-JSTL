package br.com.akira.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnecitonMySql() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/dbjava","root","123456");
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
