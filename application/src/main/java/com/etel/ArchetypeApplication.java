package com.etel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.etel")
@EnableJpaRepositories({
		"com.etel.repository"
})
@EntityScan("com.etel.model")
public class ArchetypeApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ArchetypeApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ArchetypeApplication.class, args);
	}
}
