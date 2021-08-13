package com.mock.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "Report")
public class Report {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	Report_ID PK_Report;
	
	@Column(name = "result", nullable = false)
	private String result;
	
	@Column(name = "comment")
	private String comment;

	public Report(Report_ID pK_Report, String result, String comment) {
		super();
		PK_Report = pK_Report;
		this.result = result;
		this.comment = comment;
	}

	public Report_ID getPK_Report() {
		return PK_Report;
	}

	public void setPK_Report(Report_ID pK_Report) {
		PK_Report = pK_Report;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

@Embeddable
class Report_ID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long studentID, classID;
}