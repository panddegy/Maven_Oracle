package com.biz.oracle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.oracle.sql.ScoreSumSQL;
import com.biz.oracle.vo.ScoreSumVO;

public interface ScoreSumDAO {
	
	@Select(ScoreSumSQL.SCORESUM_SELECTALL)
	public List<ScoreSumVO> selectAll();
	@Select(ScoreSumSQL.SCORESUM_FINDBYNUM)
	public ScoreSumVO findByNum(String st_num);

}
