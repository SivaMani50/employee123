package com.employee.config;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class TestConfig {

	private EmbeddedDatabase db;

	public void setUp() {
		// db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
		db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).addScript("db/sql/create-db.sql")
				.addScript("db/sql/insert-data.sql").build();
	}

}