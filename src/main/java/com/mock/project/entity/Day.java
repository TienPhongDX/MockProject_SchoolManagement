package com.mock.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Day")
public class Day implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dayID", nullable = false)
	private long dayID;
	
	public Day() {
		// TODO Auto-generated constructor stub
	}

	public Day(long dayID) {
		super();
		this.dayID = dayID;
	}

	public long getDayID() {
		return dayID;
	}

	public void setDayID(long dayID) {
		this.dayID = dayID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
