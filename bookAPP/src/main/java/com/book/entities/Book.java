package com.book.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bId;
	@Column(length = 25, nullable = false)
	private String name;
	@Column(length = 25, nullable = false)
	private String author;
	@Column(length = 25, nullable = false)
	private String publication;
	@Column(length = 25, nullable = false)
	private String category;
	private Integer pages;
	private Integer price;

}
