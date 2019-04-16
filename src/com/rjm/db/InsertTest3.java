package com.rjm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest3 {

	public static void main(String[] args) {

		// 1. DB연결 로그인

		Scanner sc = new Scanner(System.in);
		
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.21:1521:xe"; // SID
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con = null;
		Statement st = null;
		int result = 0;

		// 2. driver를 메모리에 로딩

		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");

			// 3. DB서비스에 접속해서 로그인해서 Connection 받기
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");

			// 4. Query(SQL)문 생성 - 문자열 // ; 생략
			String sql = "insert into dept values(17, 'STRIMING', 'GONGJU')";

			// 5. 전송
			st = con.createStatement();
			result = st.executeUpdate(sql);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (result > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}
}