package com.bg.dao.impl;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Equals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bg.dao.RecruitmentDao;
import com.bg.exception.BgException;
import com.bg.model.Member;
import com.bg.model.Recruitment;
import com.bg.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/spring/config/servlet-context.xml")
public class RecruitmentDaoImplTest {
	
	@Autowired
	private RecruitmentDao recruitmentDao;
	
	private Member member;
	
	@Autowired
	private MemberService memberService;
	
	@Before
	public void setUp(){
		member = new Member();
		member.setEmail("belhyun@gmail.com");
		member.setPwd("password");
	}
	
	@Test
	public void 모집공고_생성() throws DataAccessException, BgException{
		Recruitment recruitment = new Recruitment();
		recruitment.setLat("34.456");
		recruitment.setLng("128.23");
		recruitment.setLocationName("신림고등학교");
		recruitment.setRecruitmentFinishYn(true);
		recruitment.setHits(5);
		recruitment.setPhoneNumber("01066001566");
		recruitment.setStartTime(new LocalDate().toDate());
		recruitment.setEndTime(new LocalDate().toDate());
		recruitment.setCreatedAt(new LocalDate().toDate());
		recruitment.setWantPostionAndNumberofPeople("50");
		recruitment.setTitle("게스트를 모집합니다.");
		recruitment.setRequirements("매너좋으신 분");
		recruitment.setRequiredAbility(3);
		
		Member member = new Member();
		member.setEmail("belhyun@gmail.com");
		member.setPwd("password");
		
		Set<Member> guests = new HashSet<Member>();
		guests.add(member);
		recruitment.setGuests(guests);
		
		Long id = recruitmentDao.create(recruitment);
		
		Assert.assertThat(recruitmentDao.findById(id).getId(), is(equalTo(id)));
	}
}
