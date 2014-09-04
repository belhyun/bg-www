package com.bg.dao;

import com.bg.model.Member;

public abstract class MemberDao extends AbstractDao<Member>{
	
	public abstract Member findMemberByEmailAndPwd(String email, String pwd);
}
