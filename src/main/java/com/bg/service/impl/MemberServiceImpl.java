package com.bg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bg.dao.MemberDao;
import com.bg.model.Member;
import com.bg.service.MemberService;
import com.google.common.base.Preconditions;

@Service
public class MemberServiceImpl extends MemberService{

	@Autowired 
	private MemberDao memberDao;
	
	public Integer create(Member member) {
		// TODO Auto-generated method stub
		Preconditions.checkNotNull(member);
		return memberDao.create(member);
	}

	public Member findMemberByEmailAndPwd(String email, String pwd) {
		// TODO Auto-generated method stub
		Preconditions.checkNotNull(email);
		Preconditions.checkNotNull(pwd);
		memberDao.findMemberByEmailAndPwd(email, pwd);
		return null;
	}
}
