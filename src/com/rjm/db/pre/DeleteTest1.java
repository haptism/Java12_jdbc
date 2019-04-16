package com.rjm.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteTest1 {

	public static void main(String[] args) {

		// 부서번호를 입력받아서
		// dept에서 삭제

		Scanner sc = new Scanner(System.in);
		PreparedStatement st = null;
		Connection con = null;
		int result = 0;

		System.out.println("삭제할 부서번호 입력");
		result = sc.nextInt();

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

			String sql = "delete dept where deptno = ?";

			// 5. SQL 미리 전송

			st = con.prepareStatement(sql);

			// 6. ? 값 세팅
			st.setInt(1, result);

			// 7. 최종 전송 후 결과 처리
			result = st.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			// 8. 연결끊기

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
