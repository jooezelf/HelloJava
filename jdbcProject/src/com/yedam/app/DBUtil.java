package com.yedam.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	//디비접속 활용
	public static Connection getConnect() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"scott", "tiger"); 
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return conn;
	}

}
