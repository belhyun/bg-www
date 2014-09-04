package com.bg.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bg.model.Member;
import com.bg.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/spring/config/servlet-context.xml")

public class MemberServiceImplTest {
	
	@Autowired
	private MemberService memberService;
	
	@Test
	public void 멤버_생성(){
		Member member = new Member();
		member.setEmail("belhyun@gmail.com");
		member.setPwd("fuck");
		memberService.create(member);
	}
}
