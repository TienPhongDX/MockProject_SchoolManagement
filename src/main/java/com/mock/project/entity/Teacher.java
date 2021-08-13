package com.mock.project.entity;

import java.io.Serializable;
//import java.util.Date;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher")
public class Teacher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "teacherID", nullable = false)
	private long teacherID;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "birthday", nullable = false)
	private Date birthday;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "phone", nullable = false)
	private String phone;

	@Column(name = "subjectID", nullable = false)
	private int subjectID;

	@Column(name = "salary", nullable = false)
	private float salary;

	@Column(name = "photo", nullable = false)
	private String photo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subjectID", nullable = false, updatable = false, insertable = false)
	private Subject subject;
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	
	public Teacher() {
		super();
	}

	public Teacher(long teacherID, String name, Date birthday, String gender, String address, String phone,
			int subjectID, float salary, String photo) {
		super();
		this.teacherID = teacherID;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.subjectID = subjectID;
		this.salary = salary;
		this.photo = photo;
	}

	public long getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(long teacherID) {
		this.teacherID = teacherID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + teacherID + ", name=" + name + ", birthday=" + birthday + ", gender=" + gender
				+ ", address=" + address + ", phone=" + phone + ", subjectID=" + subjectID + ", salary=" + salary
				+ ", photo=" + photo + "]";
	}

}
