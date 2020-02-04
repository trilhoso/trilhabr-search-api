package br.com.trilhabr.api.config;

import br.com.trilhabr.api.ms.locais.LocaisFourSquareDetailedBuilder;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@Configuration
public class ApiConfiguration {

    @Bean
    public RestTemplate restTemplate() {
    	RestTemplate restTemplate = new RestTemplate();
    	return restTemplate;
    }

    @Bean
    public LocaisFourSquareDetailedBuilder locaisFourSquareDetailedBuilder(
            @Value("${trilhabr.pathUrlGetLocalById:config}") String pathUrlGetLocalById) {
        return new LocaisFourSquareDetailedBuilder(pathUrlGetLocalById);
    }
}
