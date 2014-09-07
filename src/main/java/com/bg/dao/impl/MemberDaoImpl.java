package com.bg.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bg.dao.MemberDao;
import com.bg.exception.BgException;
import com.bg.model.Member;
import com.bg.resource.Message;

@Repository
public class MemberDaoImpl extends AbstractDaoImpl implements MemberDao{
	
	public Member findByEmailAndPwd(String email, String pwd) throws BgException {
		// TODO Auto-generated method stub
		checkNotNull(email,pwd);
		List<?> members = hibernateTemplate.findByNamedQuery("Member.findByEmailAndPwd", 
				new Object[]{email, pwd});
		if(members.size() != BigDecimal.ONE.intValue()){
			throw new BgException(Message.SIZE_OF_MEMBER_INVALID);
		}
		return (Member) members.get(BigDecimal.ZERO.intValue());
	}
	
	public void create(Member entity) {
		// TODO Auto-generated method stub
		checkNotNull(entity);
		hibernateTemplate.saveOrUpdate("email", entity);
	}

	public Member findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
