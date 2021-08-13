package com.mock.project.dto;

import java.sql.Date;
import java.text.DecimalFormat;

public class ViewMarkBySubject {
	DecimalFormat df = new DecimalFormat("#.#");
	private String studentName;
	private Date birthday;
	private Double hs1k1;
	private Double hs2k1;
	private Double hs3k1;
	private Double totalk1;
	private Double hs1k2;
	private Double hs2k2;
	private Double hs3k2;
	private Double totalk2;
	private Double avg;
	private String result;
	private String subjectName;
	private Integer classID;
	private Integer studentID;
	
	public ViewMarkBySubject() {
		// TODO Auto-generated constructor stub
	}

	public ViewMarkBySubject(String studentName, Date birthday, Double hs1k1, Double hs2k1, Double hs3k1,
			Double totalk1, Double hs1k2, Double hs2k2, Double hs3k2, Double totalk2, Double avg, String result,
			String subjectName, Integer classID, Integer studentID) {
		super();
		this.studentName = studentName;
		this.birthday = birthday;
		this.hs1k1 = hs1k1;
		this.hs2k1 = hs2k1;
		this.hs3k1 = hs3k1;
		this.totalk1 = totalk1;
		this.hs1k2 = hs1k2;
		this.hs2k2 = hs2k2;
		this.hs3k2 = hs3k2;
		this.totalk2 = totalk2;
		this.avg = avg;
		this.result = result;
		this.subjectName = subjectName;
		this.classID = classID;
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Double getHs1k1() {
		return hs1k1;
	}

	public void setHs1k1(Double hs1k1) {
		this.hs1k1 = hs1k1;
	}

	public Double getHs2k1() {
		return hs2k1;
	}

	public void setHs2k1(Double hs2k1) {
		this.hs2k1 = hs2k1;
	}

	public Double getHs3k1() {
		return hs3k1;
	}

	public void setHs3k1(Double hs3k1) {
		this.hs3k1 = hs3k1;
	}

	public Double getTotalk1() {
		return totalk1;
	}

	public void setTotalk1(Double totalk1) {
		this.totalk1 = totalk1;
	}

	public Double getHs1k2() {
		return hs1k2;
	}

	public void setHs1k2(Double hs1k2) {
		this.hs1k2 = hs1k2;
	}

	public Double getHs2k2() {
		return hs2k2;
	}

	public void setHs2k2(Double hs2k2) {
		this.hs2k2 = hs2k2;
	}

	public Double getHs3k2() {
		return hs3k2;
	}

	public void setHs3k2(Double hs3k2) {
		this.hs3k2 = hs3k2;
	}

	public Double getTotalk2() {
		return totalk2;
	}

	public void setTotalk2(Double totalk2) {
		this.totalk2 = totalk2;
	}

	public Double getAvg() {
		return avg;
	}

	public void setAvg(Double avg) {
		this.avg = avg;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getClassID() {
		return classID;
	}

	public void setClassID(Integer classID) {
		this.classID = classID;
	}

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String format(Double mark) {
		return df.format(mark);
	}
	
	@Override
	public String toString() {
		return "ViewMarkBySubject [studentName=" + studentName + ", birthday=" + birthday + ", hs1k1=" + hs1k1
				+ ", hs2k1=" + hs2k1 + ", hs3k1=" + hs3k1 + ", totalk1=" + totalk1 + ", hs1k2=" + hs1k2 + ", hs2k2="
				+ hs2k2 + ", hs3k2=" + hs3k2 + ", totalk2=" + totalk2 + ", avg=" + avg + ", result=" + result
				+ ", subjectName=" + subjectName + ", classID=" + classID + ", studentID=" + studentID + "]";
	}

	
	
}
