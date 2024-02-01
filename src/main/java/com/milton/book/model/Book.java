package com.milton.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Book {

	@Id
	@Column
	@NotNull
	private Long id;
	@Column
	@NotEmpty(message = "must contain a title")
	private String title;
	@Column
	@NotEmpty(message = "must have an author name")
	private String author;
	@Column
	@NotNull(message = "quantity should not be empty")
	private Long quantity;
	

	public Book() {
		super();
	}
	public Book(Long id, @NotEmpty String title, @NotEmpty String author, @NotNull Long quantity) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	     
	
}
