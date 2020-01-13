package br.com.trilhabr.api.config;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

public class ApiConfiguration {

    @Bean
    public DataSource mariaDbDataSource() {
        @SuppressWarnings("unchecked")
		DataSourceBuilder<MariaDbDataSource> mariaDbDataSource = 
        		(DataSourceBuilder<MariaDbDataSource>) DataSourceBuilder.create();
    	
        return mariaDbDataSource.build();
    }
}
