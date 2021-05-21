package com.flhub.ideams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;

import com.flhub.ideams.models.SpringSecurityAuditorAware;

//@CrossOrigin

@EnableJpaAuditing(auditorAwareRef="auditorAware")
@SpringBootApplication
public class IdeamsApplication {
	
	@Bean
	public AuditorAware<String> auditorAware() {
		return new SpringSecurityAuditorAware();
	}

	public static void main(String[] args) {
		SpringApplication.run(IdeamsApplication.class, args);
	}

}
