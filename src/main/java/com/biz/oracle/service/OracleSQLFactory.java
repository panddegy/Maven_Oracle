package com.biz.oracle.service;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.biz.oracle.dao.ScoreDAO;
import com.biz.oracle.dao.ScoreSumDAO;
import com.biz.oracle.dao.StdDAO;
import com.biz.oracle.db.StdDSFactory;

public class OracleSQLFactory {
	
	SqlSessionFactory sqlSessionFactory;
	
	public OracleSQLFactory() {
		// TODO Auto-generated constructor stub
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="mybts";
		String password="1234";
		
		Properties props=new Properties();
		
		props.put("DRIVER", driver);
		props.put("URL", url);
		props.put("USER", user);
		props.put("PASSWORD", password);
		
		StdDSFactory dsf=new StdDSFactory();
		
		dsf.setProperties(props);
		
		DataSource dataSource=dsf.getDataSource();
		
		TransactionFactory transactionFactory=new JdbcTransactionFactory();
		
		Environment env=new Environment("ScoreEnv", transactionFactory, dataSource);
		
		Configuration config=new Configuration(env);
		config.addMapper(StdDAO.class);
		config.addMapper(ScoreDAO.class);
		config.addMapper(ScoreSumDAO.class);
			
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(config);
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		
		return sqlSessionFactory;
	}

}
