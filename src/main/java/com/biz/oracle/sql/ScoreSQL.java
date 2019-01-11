package com.biz.oracle.sql;

public class ScoreSQL {

	public static final String STD_INSERT=" insert into tbl_score "
			+ " values( seq_score.nextval , #{st_num}, #{st_sb_code}, #{sc_score}) ";
	
	public static final String STD_ALL=" select * from tbl_score ";
	
	public static final String STD_FIND_NUM=" select * from tbl_score where st_num=#{st_num} ";
	
	public static final String STD_UPDATE= " update tbl_score "
			+ " set st_num=#{st_num}, st_sb_code=#{st_sb_code}, sc_score=#{sc_score} where id=#{id} ";
	
	public static final String STD_DELETE= " delete from tbl_score where id=#{id} ";
	
	
	
	
	
}
