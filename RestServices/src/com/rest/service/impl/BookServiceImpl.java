package com.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rest.dao.BaseDao;
import com.rest.db.Queries;
import com.rest.entity.Book;
import com.rest.service.BookService;

public class BookServiceImpl implements BookService {

	@Autowired
	private BaseDao baseDao;
	
	@Override
	public void insertBook(Book book) {
		baseDao.executeUpdate(Queries.INSERT_BOOK_PREFIX + getJson(book) + Queries.INSERT_BOOK_SUFFIX);
	}

	@Override
	public Book getBookById(Long id) {
		return baseDao.queryUnique(Queries.SEARCH_BOOKS_BY_ID, new Object[] {id});
	}
	
	@Override
	public List<Book> getBooksByTitle(String title) {
		return baseDao.query(Queries.SEARCH_BOOKS_BY_TITLE_QUERY + title + Queries.INSERT_BOOK_SUFFIX);
	}
	
	private <T> String  getJson(T object) {
		try {
			return Queries.mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
