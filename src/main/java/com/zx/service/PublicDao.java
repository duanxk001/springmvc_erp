package com.zx.service;

import java.util.List;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zx.mybatis.inter.IUserOpration;

@Repository("publicDao")
public class PublicDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	//private SqlSessionFactoryBean sessionFactory;
	
	private SqlSessionTemplate getCurrentSession() {
		return sqlSession;
	}
	
	public List findBySQL(String sql) {
		return this.getCurrentSession().selectList(sql);
		//return this.getCurrentSession().selectList(sql);
	}

}
