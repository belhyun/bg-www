package com.bg.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
public class Guest implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private int id;
	
	@Column(name = "lat")
	private String lat;

	@Column(name = "lng")
	private String lng;
	
	@Column(name = "locationName")
	private String locationName;
	
	@ManyToOne
	@JoinColumn(name="memberId",referencedColumnName="id")
	private Member member;
	
}
