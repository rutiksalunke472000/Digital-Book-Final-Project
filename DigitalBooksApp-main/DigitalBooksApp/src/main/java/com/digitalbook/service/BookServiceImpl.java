package com.digitalbook.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbook.models.Book;
import com.digitalbook.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepo;

	@Override
	public Optional<Book> createBook(Book bdtls) {
		Book save = bookRepo.save(bdtls);
		Optional<Book> optBook = Optional.ofNullable(save);
		if (optBook.isPresent()) {
			return optBook;
		}
		return null;
	}

	@Override
	public List<Book> serachByBook(String title, String author, String publisher, LocalDate rdate) {
		List<Book> serachBooks = bookRepo.findByBooks(title, author, publisher, rdate);
		return serachBooks;
	}

	@Override
	public int updateBook(Book bkdtls, int bid, int aid) {
		bookRepo.editBookDetails(bkdtls.getTitle(), bkdtls.getCategory(), bkdtls.getPrice(), bkdtls.getAuthorName(),
				bkdtls.getPublisher(), bkdtls.getReleaseDate(), bkdtls.isActive(), bid, aid);
		return 1;
	}

	@Override
	public int blockBookDetails(int bid, int aid) {
		int blockBookDetails = bookRepo.blockBookDetails(bid, aid);
		return blockBookDetails;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> findAllBooks = bookRepo.findAll();
		return findAllBooks;
	}

	@Override
	public Book getBookById(int bookid) {
		Optional<Book> optBook = bookRepo.findById(bookid);
		if (optBook.isPresent()) {
			return optBook.get();
		}
		return (Book) Optional.empty().get();
	}
}
