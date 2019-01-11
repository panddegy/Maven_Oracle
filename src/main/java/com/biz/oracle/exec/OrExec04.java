package com.biz.oracle.exec;

import java.util.Scanner;

import com.biz.oracle.service.ScoreService;
import com.biz.oracle.service.StdService;
import com.biz.oracle.vo.ScoreSumVO;
import com.biz.oracle.vo.StdVO;

public class OrExec04 {

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
		
		System.out.println("<점수조회>");
		System.out.print("학번(0:종료)>> ");
		String st_num=sc.nextLine();
		if(st_num.equals("0")) return false;
		StdVO svo=st.stdViewInfo(st_num);
		if(svo!=null) {
			System.out.println("<학생정보>");
			System.out.println(svo);
		} else {
			System.out.println("학번없음");
			return true;
		}
		ScoreSumVO ssvo=ss.viewScoreSum(st_num);
		System.out.println("<점수정보>");
		System.out.println(ssvo);
		return true;
	}
}
