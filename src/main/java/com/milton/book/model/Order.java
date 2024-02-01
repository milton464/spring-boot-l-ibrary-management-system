package com.milton.book.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String bookname;
	@Column
	private String authorname;

	@Column
	private String username;
	
	@Column
	private long userid;

	@Column
	private Date issuedate;
	@Column
	private Date expirydate;

	public Order() {
		super();
	}

	public Order(int id, String bookname, String authorname, String username, long userid, Date issuedate,
			Date expirydate) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.authorname = authorname;
		this.username = username;
		this.userid = userid;
		this.issuedate = issuedate;
		this.expirydate = expirydate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public Date getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

}
