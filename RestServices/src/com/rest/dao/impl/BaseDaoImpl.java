package com.rest.dao.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.rest.dao.BaseDao;
import com.rest.db.Queries;
import com.rest.entity.Book;

@Transactional
public class BaseDaoImpl implements BaseDao {

    @Autowired
    private JdbcTemplate template;

	public void executeUpdate(final String query, Object[] params) {
		template.update(query, params);
	}

	@Override
	public void executeUpdate(final String query) {
		template.update(query);
	}
	
	@SuppressWarnings("unchecked")
	public <T>  List<T> query(final String query, Object[] params) {
		return (List<T>) template.query(query, params, new BookMapper<Book>(Book.class));
	}
	
	@SuppressWarnings("unchecked")
	public <T>  List<T> query(final String query) {
		return (List<T>) template.query(query, new BookMapper<Book>(Book.class));
	}
	
	@SuppressWarnings("unchecked")
	public <T>  T queryUnique(final String query, Object[] params) {
		return (T) template.queryForObject(query, params, new BookMapper<Book>(Book.class));
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}	
    
	private class  BookMapper<T> implements RowMapper<T> {
		
		private Class<T> classType;
		
		BookMapper(Class<T> clazz) {this.classType = clazz;}
		
		@Override
		public T mapRow(ResultSet rs, int rowNum) throws SQLException {
			T result = null;
			Object object =  rs.getObject(2); // Not so much of generics, but can be enhanced :)
			if(object != null) {
				try {
					result = Queries.mapper.readValue(object.toString(), classType);
				} catch (IOException  e) {
					throw new  RuntimeException(e);
				}
			}
			return result;
		}
	}
	
}
