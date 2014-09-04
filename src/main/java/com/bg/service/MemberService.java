package com.bg.service;


import javax.transaction.Transactional;

import com.bg.model.Member;

@Transactional
public abstract class MemberService implements AbstractService<Member>{
	
	public abstract Integer create(Member member);
	public abstract Member findMemberByEmailAndPwd(String email, String pwd);
}
