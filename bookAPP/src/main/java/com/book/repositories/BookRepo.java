package com.book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entities.Book;

public interface BookRepo  extends JpaRepository<Book, Integer>{

}
