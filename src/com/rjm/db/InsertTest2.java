package com.rjm.db;

public class InsertTest2 {

	public static void main(String[] args) {

		// Scanner로 입력 받아서
		// 부서번호, 부서명, 지역명을 입력 받아서
		// dept 테이블에 insert

		int deptno = 13;
		String dname = "HR";
		String loc = "Paris";

		String sql = "insert into dept" + " values(" + deptno + ", ''" + dname + "','" + loc + "')";
		System.out.println(sql);

	}
}
