package com.rjm.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest3 {

	public static void main(String[] args) {

		// DEPT 에서 부서의 갯수는 총 몇개?
		// 부서번호가 제일 큰것과 작은것.

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		// 1. 4가지 정보
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.21:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 드라이버 메모리에 로딩
		try {
			Class.forName(driver);

			// 3. Connection
			con = DriverManager.getConnection(url, user, password);

			// 4. SQL문 작성
			String sql = "select count(deptno), max(deptno), min(deptno) from dept";

			// 5. SQL 미리전송
			st = con.prepareStatement(sql);

			// 6. ?세팅

			// 7. 최종 전송 후 결과 처리
			rs = st.executeQuery();
			rs.next();
			System.out.println("Count : " + rs.getInt(1));
			System.out.println("Max: " + rs.getInt(2));
			System.out.println("Min: " + rs.getInt(3));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}