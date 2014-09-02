package com.bg.model;

import lombok.Data;

@Data
public class Member {
	private int id;
	private String email;
	private String pwd;
	
	public boolean isEmpty(){
		return email == null;
	}
}
