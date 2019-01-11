package com.biz.oracle.service;

import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.biz.oracle.dao.ScoreDAO;
import com.biz.oracle.dao.ScoreSumDAO;
import com.biz.oracle.db.StdDSFactory;
import com.biz.oracle.vo.ScoreSumVO;
import com.biz.oracle.vo.ScoreVO;

public class ScoreService {

	SqlSessionFactory sqlSessionFactory;
	

	public ScoreService() {
		// TODO Auto-generated constructor stub
		
		OracleSQLFactory os=new OracleSQLFactory();
		this.sqlSessionFactory=os.getSqlSessionFactory();
		
	}
	
	public List<ScoreVO> viewScore(String st_num){
		
		SqlSession session=this.sqlSessionFactory.openSession();
		ScoreDAO sDao=session.getMapper(ScoreDAO.class);
		
		List<ScoreVO> scoreList=sDao.findByNum(st_num);
		
		return scoreList;
	}
	
	public ScoreSumVO viewScoreSum(String st_num) {
		
		SqlSession session=this.sqlSessionFactory.openSession();
		ScoreSumDAO sDao=session.getMapper(ScoreSumDAO.class);
		
		ScoreSumVO vo=sDao.findByNum(st_num);
		
		return vo;
	}
	
	public int insertDB(ScoreVO vo) {
		
		SqlSession session=this.sqlSessionFactory.openSession();
		ScoreDAO sDao=session.getMapper(ScoreDAO.class);
		
		int ret=sDao.insert(vo);
		
		session.commit();
		session.close();
		
		return ret;
	}
	
	
}


































