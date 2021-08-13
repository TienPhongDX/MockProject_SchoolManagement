package com.mock.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Semester")
public class Semester {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "semester", nullable = false)
	private int semester;

	public Semester(int semester) {
		super();
		this.semester = semester;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
