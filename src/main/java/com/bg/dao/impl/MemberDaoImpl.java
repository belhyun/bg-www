package com.bg.dao.impl;

import org.springframework.stereotype.Repository;

import com.bg.dao.MemberDao;
import com.bg.model.Member;

@Repository
public class MemberDaoImpl extends MemberDao{
	
	@Override
	public Member findMemberByEmailAndPwd(String email, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}
}
