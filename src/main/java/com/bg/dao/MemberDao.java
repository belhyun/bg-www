package com.bg.dao;

import com.bg.exception.BgException;
import com.bg.model.Member;

public interface MemberDao extends AbstractDao{
	public static String ARGUMENT_MUST_BE_NOT_NULL = "argument must be not null";
	public abstract void create(final Member member);	
	public abstract Member findByEmailAndPwd(String email, String pwd) throws BgException;
	public abstract Member findByEmail(String email);
}
