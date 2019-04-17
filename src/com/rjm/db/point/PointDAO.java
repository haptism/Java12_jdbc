package com.rjm.db.point;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.rjm.db.utill.DBConnector;

public class PointDAO {

	// 메서드명 delete 매개변수

	// 데이터를 넣거나 꺼내오는 역할

	// 메서드명 insert 예외는 던지기 리턴은 result

	public int insert(PointDTO pointDTO) throws Exception {

		// 입력받는 코드

		Connection con = DBConnector.getConnect();

		String sql = "insert into point values(" + "?,?,?,?,?,?,?,?)";

		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, pointDTO.getNum());
		st.setString(2, pointDTO.getsId());
		st.setInt(3, pointDTO.getKor());
		st.setInt(4, pointDTO.getEng());
		st.setInt(5, pointDTO.getMath());
		st.setInt(6, pointDTO.getTotal());
		st.setDouble(7, pointDTO.getAvg());
		st.setInt(8, pointDTO.getbNum());

		// 8개 set

		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);

		return result;

		// 1. 4가지 정보

		// 2. 드라이버 메모리에 로딩

		// 3. Connection

		// 4. SQL문 작성

		// 5. SQL 미리전송

		// 6. ? 세팅

		// 7. 최종 전송 후 결과 처리

		// 8. 연결 끊기
	}
}
