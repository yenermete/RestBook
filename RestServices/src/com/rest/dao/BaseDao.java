package com.rest.dao;

import java.util.List;

public interface BaseDao {

	public void executeUpdate(final String query, Object[] params);
	
	public void executeUpdate(final String query);

	public <T> List<T> query(final String query);
	
	public <T> List<T> query(final String query, Object[] params);
	
	public <T> T queryUnique(final String query, Object[] params);
	
}
