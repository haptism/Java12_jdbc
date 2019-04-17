package com.rjm.db.point;

import java.util.Scanner;

public class PointInput {

	public PointDTO setPoint() {

		Scanner sc = new Scanner(System.in);
		PointDTO pointDTO = new PointDTO();

		System.out.println("번호를 입력");
		pointDTO.setNum(sc.nextInt());

		System.out.println("학생 ID 입력");
		pointDTO.setsId(sc.next());

		System.out.println("국어 점수 입력");
		pointDTO.setKor(sc.nextInt());

		System.out.println("영어 점수 입력");
		pointDTO.setEng(sc.nextInt());

		System.out.println("수학 점수 입력");
		pointDTO.setMath(sc.nextInt());

		System.out.println("반 번호 입력");
		pointDTO.setbNum(sc.nextInt());

		pointDTO.setTotal(pointDTO.getKor() + pointDTO.getEng() + pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getTotal() / 3.0);

		return pointDTO;
		

	}
}
