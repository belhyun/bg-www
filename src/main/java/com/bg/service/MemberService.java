package com.bg.service;


import javax.transaction.Transactional;

import com.bg.exception.BgException;
import com.bg.model.Member;

@Transactional
public abstract class MemberService implements AbstractService<Member>{
	
	public abstract void create(Member member);
	public abstract Member findMemberByEmailAndPwd(String email, String pwd) throws BgException;
}
