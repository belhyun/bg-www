package com.bg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bg.dao.MemberDao;
import com.bg.exception.BgException;
import com.bg.model.Member;
import com.bg.service.MemberService;

@Service
public class MemberServiceImpl extends MemberService{

	@Autowired 
	private MemberDao memberDao;
	
	public void create(Member member) {
		// TODO Auto-generated method stub
		memberDao.create(member);
	}

	public Member findMemberByEmailAndPwd(String email, String pwd) throws BgException {
		// TODO Auto-generated method stub
		return memberDao.findByEmailAndPwd(email, pwd);
	}
}
