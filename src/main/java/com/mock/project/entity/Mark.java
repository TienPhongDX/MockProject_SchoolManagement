package com.mock.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "Mark")
public class Mark implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId MarkID PK_Mark;
	
	@Column(name = "hs1", nullable = false)
	private float hs1;
	
	@Column(name = "hs2", nullable = false)
	private float hs2;
	
	@Column(name = "hs3", nullable = false)
	private float hs3;
	
	@Column(name = "total", nullable = false)
	private float total;
	
	public Mark() {
		// TODO Auto-generated constructor stub
	}

	public Mark(MarkID PK_Mark, float hs1, float hs2, float hs3, float total) {
		super();
		this.PK_Mark = PK_Mark;
		this.hs1 = hs1;
		this.hs2 = hs2;
		this.hs3 = hs3;
		this.total = total;
	}

	public MarkID getPK_Mark() {
		return PK_Mark;
	}

	public void setPK_Mark(MarkID pK_Mark) {
		PK_Mark = pK_Mark;
	}

	public float getHs1() {
		return hs1;
	}

	public void setHs1(float hs1) {
		this.hs1 = hs1;
	}

	public float getHs2() {
		return hs2;
	}

	public void setHs2(float hs2) {
		this.hs2 = hs2;
	}

	public float getHs3() {
		return hs3;
	}

	public void setHs3(float hs3) {
		this.hs3 = hs3;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}


@Embeddable
class MarkID implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long studentID, subjectID, classID, semester;
}