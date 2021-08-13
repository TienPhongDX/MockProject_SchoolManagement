package com.mock.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Period")
public class Period implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "periodID", nullable = false)
	private long periodID;
	
	public Period() {
		// TODO Auto-generated constructor stub
	}

	public Period(long periodID) {
		super();
		this.periodID = periodID;
	}

	public long getPeriodID() {
		return periodID;
	}

	public void setPeriodID(long periodID) {
		this.periodID = periodID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
