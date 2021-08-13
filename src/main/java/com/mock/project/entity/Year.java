package com.mock.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "start_year")
public class Year implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "start_year", nullable = false)
	private int year;
	
	public Year() {
		// TODO Auto-generated constructor stub
	}

	public Year(int year) {
		super();
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
