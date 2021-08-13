package com.mock.project.entity;

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
@Table(name = "Class")
public class Class {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "classID", nullable = false)
	private int classID;
	
	@Column(name = "gradeID", nullable = false)
	private int gradeID;
	
	@Column(name = "class_name", nullable = false)
	private String className;
	
	@Column(name = "teachercnID", nullable = false)
	private int teacherCnID;
	
	@Column(name = "size", nullable = false)
	private int size;
	
	@Column(name = "start_year", nullable = false)
	private int startYear;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "classStudying")
	private Set<Student> listStudent= new HashSet<>();
	
	public Class() {
		// TODO Auto-generated constructor stub
	}
	
	public Class(int classID, int gradeID, String className, int teacherCnID, int size, int startYear) {
		this.classID = classID;
		this.gradeID = gradeID;
		this.className = className;
		this.teacherCnID = teacherCnID;
		this.size = size;
		this.startYear = startYear;
	}
	
	public Set<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(Set<Student> listStudent) {
		this.listStudent = listStudent;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public int getGradeID() {
		return gradeID;
	}

	public void setGradeID(int gradeID) {
		this.gradeID = gradeID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getTeacherCnID() {
		return teacherCnID;
	}

	public void setTeacherCnID(int teacherCnID) {
		this.teacherCnID = teacherCnID;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
