package com.bg.model;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.validator.constraints.Email;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@SuppressWarnings("serial")

@NamedNativeQueries(value = { 
		@NamedNativeQuery(
			resultClass = Member.class,
			name = "Member.findByEmailAndPwd", 
			query = "SELECT * FROM Member WHERE email = ? AND pwd = ?")
	}
)
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
	
	@OneToMany(targetEntity = Guest.class, cascade = CascadeType.ALL, 
    		fetch = FetchType.EAGER, mappedBy="member")
    private Set<Guest> guests;
	
	public boolean isEmpty(){
		return email == null;
	}
}
