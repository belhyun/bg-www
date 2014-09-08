package com.bg.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bg.exception.BgException;
import com.bg.model.Member;
import com.bg.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/spring/config/servlet-context.xml")
public class MemberServiceImplTest {
	
	@Autowired
	private MemberService memberService;
	
	@Test
	public void 멤버_생성_성공() throws DataAccessException, BgException{
		Member member = createMember();
		memberService.create(member);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void 멤버_생성_실패() throws DataAccessException, BgException{
		memberService.create(null);
	}
	
	@Test
	public void 멤버가_존재할_경우_생성하지_않음() throws BgException{
		Member member = createMember();
		memberService.create(member);
		Assert.assertEquals(memberService.
				findMemberByEmailAndPwd("belhyun@gmail.com", "fuck").getEmail(), 
				member.getEmail());
	}
	
	private Member createMember(){
		Member member = new Member();
		member.setEmail("belhyun@gmail.com");
		member.setPwd("fuck");
		return member;
	}
}
