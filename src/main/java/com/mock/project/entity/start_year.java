package com.mock.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "start_year")
public class start_year {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "start_year", nullable = false)
	private long startYear;
	public start_year() {
		// TODO Auto-generated constructor stub
	}

	public start_year(long startYear) {
		super();
		this.startYear = startYear;
	}

	public long getStartYear() {
		return startYear;
	}

	public void setStartYear(long startYear) {
		this.startYear = startYear;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
