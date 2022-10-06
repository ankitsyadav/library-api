package com.book.services;

import java.util.List;

import com.book.payload.BookDto;

public interface BookService {

	public List<BookDto> getAllBooks();

	public BookDto getBookById(Integer bId);

	public BookDto addNewBook(BookDto bdto);

	public void deleteBook(Integer bId);

	public BookDto updateBook(BookDto bdto, Integer bId);

}
