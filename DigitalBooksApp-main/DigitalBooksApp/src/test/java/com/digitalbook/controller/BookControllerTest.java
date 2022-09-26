package com.digitalbook.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.digitalbook.controllers.BookController;
import com.digitalbook.models.Book;

import com.digitalbook.service.BookService;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
	@Mock
	private BookService bservice;
	
	@InjectMocks
	private BookController bcontroller;
	
	@Test
	public void testCreateBook() {
		Book btls=new Book();
		Optional<Book> ofNullable = Optional.ofNullable(btls);
		when(bservice.createBook(btls)).thenReturn(ofNullable);
		ResponseEntity<?> createBook = bcontroller.createBook(btls, 10);
		int value = createBook.getStatusCode().value();
		//System.out.println(value);
		assertEquals(400, createBook.getStatusCode().value());
	}
	@Test
	public void testCreateBook1() {
		Book btls=new Book();
		btls.setId(10);
		btls.setTitle("A BOOK BY");
		Optional<Book> ofNullable = Optional.ofNullable(btls);
		when(bservice.createBook(btls)).thenReturn(ofNullable);
		ResponseEntity<?> createBook = bcontroller.createBook(btls, 10);
		int value = createBook.getStatusCode().value();
		System.out.println(value);
		assertEquals(200, createBook.getStatusCode().value());
	}
	@Test
	public void testSerachByBook() {
		List<Book> booksList=new ArrayList<>();
		when(bservice.serachByBook("WINGS OF FIRE", "abdulkalam", "Arihant Books", LocalDate.now())).thenReturn(booksList);
	List<Book> serachByBook = bcontroller.serachByBook("WINGS OF FIRE", "abdulkalam", "Arihant Books", null);
	assertEquals(booksList, serachByBook);
	}
	
	@Test
	public void testSerachByBook1() {
		List<Book> booksList=new ArrayList<>();
		when(bservice.serachByBook("WINGS OF FIRE", "abdulkalam", "Arihant Books", LocalDate.now())).thenReturn(booksList);
	List<Book> serachByBook = bcontroller.serachByBook("WINGS OF FIRE", "abdulkalam", "Arihant Books", LocalDate.now().toString());
	assertEquals(booksList, serachByBook);
	}
	@Test
	public void testGetAllBooks() {
		List<Book> bookList=new ArrayList<>();
		when(bservice.getAllBooks()).thenReturn(bookList);
		List<Book> allBookDetails = bcontroller.getAllBookDetails();
		assertEquals(bookList, allBookDetails);
	}
	@Test
	public void testGetBookById() {
		Book bkdtls=new Book();
		when(bservice.getBookById(10)).thenReturn(bkdtls);
		Book bookDetailsById = bcontroller.getBookDetailsById(10);
		assertEquals(bkdtls, bookDetailsById);
	}
	
}
