package com.mock.project.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Subject")
public class Subject implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subjectID", nullable = false)
	private int subjectID;

	@Column(name = "subject_name", nullable = false)
	private String subjectName;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "subjectID")
	private Set<Teacher> listTeacher= new HashSet<>();
	
	public Set<Teacher> getListTeacher() {
		return listTeacher;
	}
	public void setListTeacher(Set<Teacher> listTeacher) {
		this.listTeacher = listTeacher;
	}

	
	public Subject() {
		// TODO Auto-generated constructor stub
	}
	public Subject(int subjectID, String subjectName) {
		super();
		this.subjectID = subjectID;
		this.subjectName = subjectName;
	}

	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
