package dev.ledesma.highscores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@ComponentScan(basePackages = {"dev.ledesma"})
@EntityScan(basePackages = {"dev.ledesma.entities"})
@EnableJpaRepositories(basePackages = {"dev.ledesma.repos"})

public class HighscoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(HighscoresApplication.class, args);
	}

}
