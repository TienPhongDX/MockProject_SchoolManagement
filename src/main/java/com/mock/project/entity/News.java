package com.mock.project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "News")
public class News {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "newsID", nullable = false)
	private long newsID;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "thumbnail", nullable = false)
	private String thumbnail;
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	public News(long newsID, String title, String thumbnail, String content, Date createdDate) {
		super();
		this.newsID = newsID;
		this.title = title;
		this.thumbnail = thumbnail;
		this.content = content;
		this.createdDate = createdDate;
	}

	public long getNewsID() {
		return newsID;
	}

	public void setNewsID(long newsID) {
		this.newsID = newsID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
