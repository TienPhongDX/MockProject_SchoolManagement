package com.mock.project.entity;

import java.io.Serializable;
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
@Table(name = "Student")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentID", nullable = false)
	private long studentID;

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

	@Column(name = "class_studying")
	private Integer classStudying;

	@Column(name = "photo", nullable = false)
	private String photo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "class_studying", nullable = false, updatable = false, insertable = false)
	private Class classs;
	

	public Class getClasss() {
		return classs;
	}

	public void setClasss(Class classs) {
		this.classs = classs;
	}

	public Student() {
		super();
	}

	public Student(long studentID, String name, Date birthday, String gender, String address, String phone,
			Integer classStudying, String photo) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.classStudying = classStudying;
		this.photo = photo;
	}

	public long getStudentID() {
		return studentID;
	}

	public void setStudentID(long studentID) {
		this.studentID = studentID;
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

	public Integer getClassStudying() {
		return classStudying;
	}

	public void setClassStudying(Integer classStudying) {
		this.classStudying = classStudying;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", birthday=" + birthday + ", gender=" + gender
				+ ", address=" + address + ", phone=" + phone + ", classStudying=" + classStudying + ", photo=" + photo
				+ "]";
	}
	
	
	
}
