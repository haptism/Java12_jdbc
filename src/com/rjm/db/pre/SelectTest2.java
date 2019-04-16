package com.rjm.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectTest2 {

	public static void main(String[] args) {

		// 조회할 부서 번호를 입력 받기
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		System.out.println("조회할 부서 번호 입력");
		int deptno = sc.nextInt();

		// 1. 4가지 정보
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.21:1521:xe"; // SID
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 2. 드라이버 로딩
		try {
			Class.forName(driver);

			// 3. Connection
			con = DriverManager.getConnection(url, user, password);

			// 4. SQL문 작성
			String sql = "select * from dept where deptno = ?";

			// 5. SQL 미리전송
			st = con.prepareStatement(sql);

			// 6. ? 세팅
			st.setInt(1, deptno);

			// 7. 최종 전송 후 결과 처리
			rs = st.executeQuery();

			if (rs.next()) {
				System.out.println("부서 번호 : " + rs.getInt("deptno"));
			} else {
				System.out.println("없는 부서 번호 입니다.");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			// 8. 연결 끊기

		}
		try {
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
