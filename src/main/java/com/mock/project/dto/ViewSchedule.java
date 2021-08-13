package com.mock.project.dto;

public class ViewSchedule {
	
	private int periodID;
	private int dayID;
	private String className;
	private int teacherID;
	private int startYear;
	
	public ViewSchedule() {
		// TODO Auto-generated constructor stub
	}

	public ViewSchedule(int periodID, int dayID, String className, int teacherID, int startYear) {
		super();
		this.periodID = periodID;
		this.dayID = dayID;
		this.className = className;
		this.teacherID = teacherID;
		this.startYear = startYear;
	}

	public int getPeriodID() {
		return periodID;
	}

	public void setPeriodID(int periodID) {
		this.periodID = periodID;
	}

	public int getDayID() {
		return dayID;
	}

	public void setDayID(int dayID) {
		this.dayID = dayID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	@Override
	public String toString() {
		return "ViewSchedule [periodID=" + periodID + ", dayID=" + dayID + ", className=" + className + ", teacherID="
				+ teacherID + ", startYear=" + startYear + "]";
	}

	
}
