package com.jdc.mkt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jdc.mkt.model.BaseRepoImpl;

@SpringBootApplication
@EnableJpaRepositories(
		repositoryBaseClass = BaseRepoImpl.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
