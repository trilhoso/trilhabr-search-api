package br.com.trilhabr.api.config;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiConfiguration {

//    @Bean
//    public DataSource mariaDbDataSource() {
//        @SuppressWarnings("unchecked")
//		DataSourceBuilder<MariaDbDataSource> mariaDbDataSource = 
//        		(DataSourceBuilder<MariaDbDataSource>) DataSourceBuilder.create();
//    	
//        return mariaDbDataSource.build();
//    }
    
    @Bean
    public RestTemplate restTemplate() {
    	RestTemplate restTemplate = new RestTemplate();
    	return restTemplate;
    }
}
