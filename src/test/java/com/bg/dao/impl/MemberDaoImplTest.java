package com.bg.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bg.dao.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/spring/config/servlet-context.xml")
public class MemberDaoImplTest {
	
	@Autowired
	private MemberDao memberDao;
	
	@Test(expected = IllegalArgumentException.class)
	public void 전달인자가_NULL일_경우(){
		memberDao.checkNotNull(null,null);
	}
}
