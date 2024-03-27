package com.eduardodecarvalho.simplifiedbankssytem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@EnableJdbcAuditing
@SpringBootApplication
public class SimplifiedBankSsytemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplifiedBankSsytemApplication.class, args);
	}

}
