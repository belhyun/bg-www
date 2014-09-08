package com.bg.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.dao.DataAccessException;
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
		if(members.size() == BigDecimal.ZERO.intValue()){
			return null;
		}else if(members.size() == BigDecimal.ONE.intValue()){
			return (Member) members.get(BigDecimal.ZERO.intValue());
		}else if(members.size() > BigDecimal.ONE.intValue()){
			throw new BgException(Message.SIZE_OF_MEMBER_INVALID);
		}
		return null;
	}
	
	public void create(Member entity) throws DataAccessException, BgException {
		// TODO Auto-generated method stub
		checkNotNull(entity);
		if(findByEmailAndPwd(entity.getEmail(), entity.getPwd()) == null){
			hibernateTemplate.save(entity);
		}
	}

	public Member findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
