package com.biz.oracle.exec;

import com.biz.oracle.service.StdService;

public class OrExec02 {

	public static void main(String[] args) {
		
		StdService ss=new StdService();
		
		ss.insert();
		ss.stdView();
	}
}
