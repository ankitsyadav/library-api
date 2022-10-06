package com.book.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.payload.ApiResponse;
import com.book.payload.BookDto;
import com.book.services.BookService;

@Controller
@RequestMapping("/bookservice")
public class BookController {

	@Autowired
	private BookService bs;

//	 create book 

	@PostMapping("/books")
	public ResponseEntity<BookDto> addNewBook(@Valid @RequestBody BookDto bdto) {
		BookDto createdBookDto = this.bs.addNewBook(bdto);
		return new ResponseEntity<>(createdBookDto, HttpStatus.CREATED);

	}

// update book 	

	@PutMapping("/books/{bId}")
	public ResponseEntity<BookDto> updateBook(@Valid @RequestBody BookDto bdto, @PathVariable Integer bId) {

		BookDto updatedBdto = this.bs.updateBook(bdto, bId);

		return new ResponseEntity<>(updatedBdto, HttpStatus.OK);

	}

//	get  books by ID

	@GetMapping("/books/{bId}")
	public ResponseEntity<BookDto> getBookByID(@PathVariable Integer bId) {

		BookDto bdto_found = this.bs.getBookById(bId);

		return new ResponseEntity<>(bdto_found, HttpStatus.OK);

	}

//	get all books

	@GetMapping("/books")
	public ResponseEntity<List<BookDto>> getAllBooks() {

		List<BookDto> booklist = this.bs.getAllBooks();

		return new ResponseEntity<>(booklist, HttpStatus.OK);

	}

//	delete book

	@DeleteMapping("/books/{bId}")
	public ResponseEntity<ApiResponse> deleteBook(@PathVariable Integer bId) {

		this.bs.deleteBook(bId);

		return new ResponseEntity<>(new ApiResponse("deleted successfully", true), HttpStatus.OK);

	}

}
