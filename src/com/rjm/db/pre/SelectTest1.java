package com.rjm.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest1 {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		// 1. 4가지 정보

		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.21:1521:xe"; // SID
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 드라이버를 메모리에 로딩
		try {
			Class.forName(driver);

			// 3. 로그인 후 Connection 객체 받아오기
			con = DriverManager.getConnection(url, user, password);

			// 4. SQL문 작성

			String sql = "select * from dept order by deptno desc";

			// 5. SQL 미리 전송
			st = con.prepareStatement(sql);

			// 6. ? 값 세팅

			// 7. 최종 전송 후 결과 처리
			rs = st.executeQuery();

			while (rs.next()) {
				System.out.println("부서 번호 : " + rs.getInt("deptno"));
				System.out.println("부서 명 : " + rs.getString("dname"));
				System.out.println("지역 명 : " + rs.getString("loc"));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			// 8. 연결끊기

			try {
				rs.close();
				st.close();
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
