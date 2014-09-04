package com.bg.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bg.dao.MemberDao;
import com.bg.model.Member;

@Repository
public class MemberDaoImpl extends MemberDao{
	
	public MemberDaoImpl() {
		// TODO Auto-generated constructor stub
		super();
		setClazz(Member.class);
	}
}
