package com.biz.oracle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biz.oracle.sql.ScoreSQL;
import com.biz.oracle.vo.ScoreVO;

public interface ScoreDAO {
	
	@Select(ScoreSQL.STD_ALL)
	public List<ScoreVO> selectAll();
	
	@Select(ScoreSQL.STD_FIND_NUM)
	public List<ScoreVO> findByNum(String st_num);
	
	@Insert(ScoreSQL.STD_INSERT)
	public int insert(ScoreVO vo);
	
	@Update(ScoreSQL.STD_UPDATE)
	public int update(ScoreVO vo);
	
	@Delete(ScoreSQL.STD_DELETE)
	public int delete(long id);

}
