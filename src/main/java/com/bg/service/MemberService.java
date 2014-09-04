package com.bg.service;

import javax.transaction.Transactional;

import com.bg.model.Member;

@Transactional
public interface MemberService {
	
	public Member create(Member member);
}
