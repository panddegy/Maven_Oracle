package com.biz.oracle.service;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.biz.oracle.dao.StdDAO;
import com.biz.oracle.db.StdDSFactory;
import com.biz.oracle.vo.StdVO;

public class StdService {
	
	Scanner sc;
	SqlSessionFactory sessionFactory;
	
	public StdService() {
		// TODO Auto-generated constructor stub
		OracleSQLFactory os=new OracleSQLFactory();
		this.sessionFactory=os.getSqlSessionFactory();
	}
	
	public void stdView() {
		
		SqlSession session=this.sessionFactory.openSession();
		StdDAO dao=session.getMapper(StdDAO.class);
		
		List<StdVO> stList=dao.selectAll();
		
		for(StdVO vo:stList) {
			System.out.println(vo);
		}
	}
	
	public void insert() {
		
		SqlSession session=this.sessionFactory.openSession();
		StdDAO dao=session.getMapper(StdDAO.class);
		
		StdVO vo=stdInfoInput();
		if(vo==null) return;
		
		if(dao.insert(vo)>0) System.out.println("입력이 완료되었습니다.");
		else System.out.println("입력이 실패하였습니다.");
		
		session.commit();
		session.close();
	}
	public void update() {
		
		SqlSession session=this.sessionFactory.openSession();
		StdDAO dao=session.getMapper(StdDAO.class);
		
		StdVO vo=stdInfoInput();
		if(vo==null) return;
		
		if(dao.update(vo)>0) System.out.println("입력이 완료되었습니다.");
		else System.out.println("입력이 실패하였습니다.");
		
		session.commit();
		session.close();
	}
	
	public StdVO stdInfoInput() {
		
		StdVO vo=null;
		System.out.print("학번(0:종료) >> ");
		String st_num=sc.nextLine();
		if(st_num.equals("0")) return vo; 
		System.out.print("이름 >> ");
		String st_name=sc.nextLine();
		System.out.print("학년 >> ");
		String st_grade=sc.nextLine();
		System.out.print("전화번호 >> ");
		String st_tel=sc.nextLine();
		
		vo=new StdVO(st_num,st_name,st_grade,st_tel);
		
		return vo;
	}

	public StdVO stdViewInfo(String st_num) {
		// TODO Auto-generated method stub
		
		SqlSession session=this.sessionFactory.openSession();
		StdDAO dao=session.getMapper(StdDAO.class);
		
		StdVO vo=dao.findByNum(Integer.valueOf(st_num));
		
		return vo;
	}

}














