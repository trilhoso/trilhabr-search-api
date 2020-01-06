package br.com.trilhabr.api.config;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

public class ApiConfiguration {

    @Bean
    public DataSource mariaDbConnection() {
        return new MariaDbDataSource();
    }
}
