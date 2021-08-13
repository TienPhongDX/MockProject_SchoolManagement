package com.mock.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Grade")
public class Grade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "gradeID", nullable = false)
	private int gradeID;
	
	public Grade() {
		// TODO Auto-generated constructor stub
	}

	public Grade(int gradeID) {
		super();
		this.gradeID = gradeID;
	}

	public int getGradeID() {
		return gradeID;
	}

	public void setGradeID(int gradeID) {
		this.gradeID = gradeID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
