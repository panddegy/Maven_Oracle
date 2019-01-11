package com.biz.oracle.exec;

import java.util.Scanner;

import com.biz.oracle.service.ScoreService;
import com.biz.oracle.service.StdService;
import com.biz.oracle.vo.ScoreVO;
import com.biz.oracle.vo.StdVO;

public class OrExec05 {

	static Scanner sc;
	static ScoreService ss;
	static StdService st;
	
	public static void main(String[] args) {

		ss=new ScoreService();
		st=new StdService();
		sc=new Scanner(System.in);
		
		while(infoView()) {
		}
	}
	
	public static boolean infoView() {
		
		st.stdView();
		System.out.println("<학생정보조회>");
		System.out.print("학번(0:종료)>> ");
		String st_num=sc.nextLine();
		if(st_num.equals("0")) return false;
		StdVO svo=st.stdViewInfo(st_num);
		if(svo!=null) {
			System.out.println("<학생정보>");
			System.out.println(svo);
			insertScore(st_num);
		} else {
			System.out.println("학번없음");
		}
		return true;
	}
	
	public static void insertScore(String st_num) {
		
		System.out.println("<점수입력>");
		System.out.println("과목코드(국어:001 영어:002 수학:003) ");
		System.out.print("코드>> ");
		String st_sb_code=sc.nextLine();
		System.out.print("점수>> ");
		String strScore=sc.nextLine();
		int sc_score=Integer.valueOf(strScore);
		
		ScoreVO vo=new ScoreVO();
		
		vo.setSt_num(st_num);
		vo.setSc_score(sc_score);
		vo.setSt_sb_code(st_sb_code);
				
		int ret=ss.insertDB(vo);
		if(ret>0) System.out.println("입력완료");
		else System.out.println("입력실패");
		
	}
}

	

