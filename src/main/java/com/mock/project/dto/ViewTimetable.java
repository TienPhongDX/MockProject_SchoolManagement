package com.mock.project.dto;

public class ViewTimetable {

	private Long periodID;

	private Long dayID;

	private String name;

	private String subjectName;

	private Long classID;

	public ViewTimetable() {
		// TODO Auto-generated constructor stub
	}

	public ViewTimetable(Long periodID, Long dayID, String name, String subjectName, Long classID) {
		super();
		this.periodID = periodID;
		this.dayID = dayID;
		this.name = name;
		this.subjectName = subjectName;
		this.classID = classID;
	}

	public Long getPeriodID() {
		return periodID;
	}

	public void setPeriodID(Long periodID) {
		this.periodID = periodID;
	}

	public Long getDayID() {
		return dayID;
	}

	public void setDayID(Long dayID) {
		this.dayID = dayID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Long getClassID() {
		return classID;
	}

	public void setClassID(Long classID) {
		this.classID = classID;
	}

	@Override
	public String toString() {
		return "ViewTimetable [periodID=" + periodID + ", dayID=" + dayID + ", name=" + name + ", subjectName="
				+ subjectName + ", classID=" + classID + "]";
	}

}
