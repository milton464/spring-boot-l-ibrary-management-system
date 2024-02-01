package com.milton.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milton.book.model.Book;
import com.milton.book.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	
	
	public void addBook(Book book) {
		bookRepository.save(book);
	}

	
	
	public List<Book> bookList() {
		return bookRepository.findAll();
	}



	public List<Book> findByTitle(String title) {
		
		return bookRepository.findByTitleLike("%"+title+"%");
	}

public Book findBytitle(String name) {
	return bookRepository.findBytitle(name);
}

	public Book findById(Long id) {
		Optional<Book>optional = bookRepository.findById(id); 
		Book book = optional.get();
		return book;
	}



	

}
