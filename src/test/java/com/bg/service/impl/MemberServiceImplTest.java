package com.bg.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
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
	public void 멤버_생성_성공(){
		Member member = new Member();
		member.setEmail("belhyun@gmail.com");
		member.setPwd("fuck");
		Assert.assertNotNull(memberService.create(member));
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected = NullPointerException.class)
	public void 멤버_생성_실패(){
		Mockito.when(memberService.create(null)).thenThrow(NullPointerException.class);
	}
}
