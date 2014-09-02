package com.bg.model;

import org.junit.Assert;
import org.junit.Test;

public class MemberTest {
	
	@Test
	public void 멤버_is_empty(){
		Member member = new Member();
		Assert.assertTrue(member.isEmpty());
		
	}
}