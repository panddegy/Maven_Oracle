package com.biz.oracle.exec;

import java.util.List;
import java.util.Scanner;

import com.biz.oracle.service.ScoreService;
import com.biz.oracle.vo.ScoreVO;

public class OrExec03 {

	public static void main(String[] args) {
		
		ScoreService ss=new ScoreService();
		Scanner sc=new Scanner(System.in);
		
		System.out.print("학번>> ");
		String st_num=sc.nextLine();
		List<ScoreVO> scoreList=ss.viewScore(st_num);
		
		for(ScoreVO vo:scoreList) {
			System.out.println(vo);
		}
		
		
	}
}
