package com.digitalbook.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.digitalbook.models.Book;

public interface BookService {
	public Optional<Book> createBook(Book bdtls);

	public int updateBook(Book bdtls, int bid, int aid);

	public List<Book> serachByBook(String title, String auhtor, String publisher, LocalDate rdate);

	public int blockBookDetails(int bid, int aid);

	public List<Book> getAllBooks();

	public Book getBookById(int bookid);
}
