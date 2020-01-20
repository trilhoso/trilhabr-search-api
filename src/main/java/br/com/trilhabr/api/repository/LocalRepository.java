package br.com.trilhabr.api.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class LocalRepository {

	@Autowired
	DataSource ds;
	
	private final static String SQL_LIST_LOCAIS = "";

}
