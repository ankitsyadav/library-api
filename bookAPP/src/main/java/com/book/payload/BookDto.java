package com.book.payload;

import lombok.Data;

@Data
public class BookDto {

	private Integer bId;

	
	private String name;
	private String author;

	private String publication;

	private String category;
	private Integer pages;
	private Integer price;

}
