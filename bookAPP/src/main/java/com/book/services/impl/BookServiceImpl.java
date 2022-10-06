package com.book.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entities.Book;
import com.book.exceptions.ResourceNotFoundException;
import com.book.payload.BookDto;
import com.book.repositories.BookRepo;
import com.book.services.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo br;

	@Autowired
	private ModelMapper mp;

	@Override
	public List<BookDto> getAllBooks() {
		List<Book> books = this.br.findAll();

		List<BookDto> booklist = new ArrayList<>();

		for (Book b : books) {

			BookDto x = this.mp.map(b, BookDto.class);

			booklist.add(x);

		}
		return booklist;

	}

	@Override
	public BookDto getBookById(Integer bId) {
		Book book = this.br.findById(bId).orElseThrow(() -> new ResourceNotFoundException(bId));
		return this.mp.map(book, BookDto.class);
	}

	@Override
	public BookDto addNewBook(BookDto bdto) {
		Book book = this.mp.map(bdto, Book.class);

		Book savedBook = this.br.save(book);
		return this.mp.map(savedBook, BookDto.class);
	}

	@Override
	public void deleteBook(Integer bId) {
		Book book = this.br.findById(bId).orElseThrow(() -> new ResourceNotFoundException(bId));
		this.br.delete(book);

	}

	@Override
	public BookDto updateBook(BookDto bdto, Integer bId) {

		Book book = this.br.findById(bId).orElseThrow(() -> new ResourceNotFoundException(bId));
		book.setAuthor(bdto.getAuthor());
		book.setCategory(bdto.getCategory());
		book.setName(bdto.getName());
		book.setPages(bdto.getPages());
		book.setPrice(bdto.getPrice());
		book.setPublication(bdto.getPublication());

		Book savedBook = this.br.save(book);
		return this.mp.map(savedBook, BookDto.class);

	}

}
