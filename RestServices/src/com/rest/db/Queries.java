package com.rest.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class Queries {

	public static final String INSERT_BOOK_PREFIX = "insert into REST.BOOK(ID, DETAILS) values(NEXTVAL('REST.BOOK_SEQ'), '";
	
	public static final String INSERT_BOOK_SUFFIX = "')";
	
	public static final String GENERAL_STRING_SUFFIX = "'";
	
	public static final String SEARCH_BOOKS_BY_TITLE_QUERY = "select * from REST.BOOK b where lower(b.details->>'title') = lower('";
	
	public static final String SEARCH_BOOKS_BY_ID = "select * from REST.BOOK b where b.id = ?";
	
	public static final ObjectMapper mapper = new ObjectMapper().registerModule(new JodaModule());
	
}
