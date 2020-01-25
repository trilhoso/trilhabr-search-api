package br.com.trilhabr.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"br.com.trilhabr.api", "br.com.trilhabr.api.controller"})
public class TrilhabrSearchApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrilhabrSearchApiApplication.class, args);
	}

}
