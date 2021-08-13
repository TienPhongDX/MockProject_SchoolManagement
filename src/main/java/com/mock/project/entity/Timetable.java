package com.mock.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Timetable")
public class Timetable implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	Timetable_ID PK_Timetable;
	
	@Column(name = "teacherID", nullable = false)
	private Long teacherID;

	public Timetable(Timetable_ID pK_Timetable, Long teacherID) {
		super();
		PK_Timetable = pK_Timetable;
		this.teacherID = teacherID;
	}

	public Timetable_ID getPK_Timetable() {
		return PK_Timetable;
	}

	public void setPK_Timetable(Timetable_ID pK_Timetable) {
		PK_Timetable = pK_Timetable;
	}

	public Long getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(Long teacherID) {
		this.teacherID = teacherID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

@Embeddable
class Timetable_ID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long classID, dayID, periodID;
	
	public Timetable_ID() {
		// TODO Auto-generated constructor stub
	}

	public Timetable_ID(long classID, long dayID, long periodID) {
		super();
		this.classID = classID;
		this.dayID = dayID;
		this.periodID = periodID;
	}

	public long getClassID() {
		return classID;
	}

	public void setClassID(long classID) {
		this.classID = classID;
	}

	public long getDayID() {
		return dayID;
	}

	public void setDayID(long dayID) {
		this.dayID = dayID;
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