package com.bg.service;


import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;

import com.bg.exception.BgException;
import com.bg.model.Member;

@Transactional
public abstract class MemberService implements AbstractService<Member>{
	
	public abstract void create(Member member) throws DataAccessException, BgException;
	public abstract Member findMemberByEmailAndPwd(String email, String pwd) throws BgException;
}
