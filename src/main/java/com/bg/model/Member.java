package com.bg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
public class Member implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private int id;
	@NotNull
	@Email
	@Column(name = "email")
	private String email;
	@NotNull
	@Column(name = "pwd")
	private String pwd;
	
	public boolean isEmpty(){
		return email == null;
	}
}
