package com.biz.oracle.sql;

public class StdSQL {

	public static final String STD_INSERT=" insert into tbl_student "
			+ " values( #{st_num}, #{st_name}, #{st_grade}, #{st_tel}) ";
	
	public static final String STD_ALL=" select * from tbl_student ";
	
	public static final String STD_FIND_NUM=" select * from tbl_student where st_num=#{st_num} ";
	
	public static final String STD_FIND_NAME=" select * from tbl_student where st_name=#{st_name} ";
	
	public static final String STD_UPDATE= " update tbl_student "
			+ " set st_name=#{st_name}, st_grade=#{st_grade}, st_tel=#{st_tel} where st_num=#{st_num} ";
	
	public static final String STD_DELETE= " delete from tbl_student where st_num=#{st_num} ";
	
	
	
	
	
}
