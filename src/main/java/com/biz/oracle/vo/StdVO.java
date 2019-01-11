package com.biz.oracle.vo;

import lombok.Data;

@Data
public class StdVO {
	
	private String st_num;
	private String st_name;
	private String st_grade;
	private String st_tel;
	
	public StdVO(String st_num, String st_name, String st_grade, String st_tel) {
		super();
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_grade = st_grade;
		this.st_tel = st_tel;
	}

}
