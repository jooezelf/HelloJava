package com.yedam.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 본인 DB 정보에 맞게 수정
	private static final String USER = "hr"; // 본인 DB 사용자명으로 수정
	private static final String PASS = "hr"; // 본인 DB 비밀번호로 수정
	
	public static Connection getConnect() {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		return null;
	}
}