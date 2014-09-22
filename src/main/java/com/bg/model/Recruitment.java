package com.bg.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
public class Recruitment implements Serializable{
	
	/*
	@ManyToOne
	@JoinColumn(name="memberId",referencedColumnName="id")
	@NotNull
	*/
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="MemberRecruitment"
			,joinColumns=
				@JoinColumn(name="guestId", referencedColumnName="id")
			,inverseJoinColumns=
				@JoinColumn(name="recruitmentId", referencedColumnName="id")
	)
	private Set<Member> guests;
	
	@NotNull
	private int memberId;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private long id;
	
	@Column(name = "lat")
	private String lat;

	@Column(name = "lng")
	private String lng;
	
	@Column(name = "locationName", length = 100)
	private String locationName;
	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name="recruitmentFinishYn", nullable = false)
	@ColumnDefault(value="false")
	private boolean recruitmentFinishYn;
	
	@ColumnDefault(value="0")
	@Column(name="hits")
	private int hits;
	
	@NotNull
	@Column(name="phoneNumber", length = 30)
	private String phoneNumber;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="startTime")
	@NotNull
	private Date startTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="endTime")
	@NotNull
	private Date endTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdAt")
	@NotNull
	private Date createdAt;
	
	@NotNull
	@Column(name="wantPostionAndNumberofPeople", nullable = false, length = 50)
	private String wantPostionAndNumberofPeople;
	
	@Column(name="title", nullable = false)
	@NotBlank
	@NotNull
	private String title;
	
	@Column(columnDefinition = "TEXT", name="requirements", nullable = true)
	private String requirements;
	
	@Column(columnDefinition = "TINYINT", name="requiredAbility")
	@ColumnDefault(value="0")
	private int requiredAbility;
}
