package com.rjm.db.point;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PointInsert {

	public static void main(String[] args) {
		// id, 국어, 영어, 수학, 입력
		// point table에 insert
		try {
			new PointController().start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//		Scanner sc = new Scanner(System.in);
//		Connection con = null;
//		PreparedStatement st = null;
//		int result = 0;
//
//		String id = "Kim";
//		int kor = 40;
//		int eng = 50;
//		int math = 20;
//		int total = kor + eng + math;
//		double avg = total / 3;
//
//		// 1. 로그인 정보 4가지
//
//		String user = "user01";
//		String password = "user01";
//		String url = "jdbc:oracle:thin:@211.238.142.21:1521:xe"; // SID
//		String driver = "oracle.jdbc.driver.OracleDriver";
//
//		// 2. 드라이버를 메모리에 로딩
//		try {
//			Class.forName(driver);
//
//			// 3. 로그인 후 Connection 객체 받아오기
//			con = DriverManager.getConnection(url, user, password);
//
//			// 4. SQL문을 작성
//			String sql = "insert into point values(?, ?, ?, ?, ?, ?)";
//
//			// 5. SQL 미리 전송
//			st = con.prepareStatement(sql);
//
//			// 6. ? 값 세팅
//			// st.setXXX (?의 인덱스 번호, 해당하는 값);
//			
//			st.setString(1, id);
//			st.setInt(2, kor);
//			st.setInt(3, eng);
//			st.setInt(4, math);
//			st.setInt(5, total);
//			st.setDouble(6, avg);
//
//			// 7. 최종 전송 후 결과 처리
//			result = st.executeUpdate();
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			
//			try {
//				st.close();
//				con.close();
//				
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		if (result > 0) {
//			System.out.println("성공");
//		} else {
//			System.out.println("실패");
//		}
//	}
//}