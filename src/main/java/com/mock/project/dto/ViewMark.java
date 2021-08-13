package com.mock.project.dto;

import java.text.DecimalFormat;

/**
 * @author ADMIN
 *
 */
public class ViewMark {
	private static DecimalFormat df = new DecimalFormat("#.#");
	
	private String subjectName;
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
	
	public ViewMark() {
		// TODO Auto-generated constructor stub
	}

	public ViewMark(String subjectName, Double hs1k1, Double hs2k1, Double hs3k1, Double totalk1, Double hs1k2,
			Double hs2k2, Double hs3k2, Double totalk2, Double avg, String result) {
		super();
		this.subjectName = subjectName;
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
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
	
	public String getMark(double m) {
		
		return df.format(m);
		
	}

	@Override
	public String toString() {
		return "ViewMark [subjectName=" + subjectName + ", hs1k1=" + hs1k1 + ", hs2k1=" + hs2k1 + ", hs3k1=" + hs3k1
				+ ", totalk1=" + totalk1 + ", hs1k2=" + hs1k2 + ", hs2k2=" + hs2k2 + ", hs3k2=" + hs3k2 + ", totalk2="
				+ totalk2 + ", avg=" + avg + ", result=" + result + "]";
	}
	
}
