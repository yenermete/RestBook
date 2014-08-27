package com.rest.service;

import java.util.List;

import com.rest.entity.Book;


public interface BookService {

	public void insertBook(Book book);
	
	public Book getBookById(Long id);
	
	public List<Book> getBooksByTitle(String title);

}
