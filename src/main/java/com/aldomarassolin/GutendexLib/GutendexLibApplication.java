package com.aldomarassolin.GutendexLib;

import com.aldomarassolin.GutendexLib.principal.Principal;
import com.aldomarassolin.GutendexLib.repository.BookRepository;
import com.aldomarassolin.GutendexLib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GutendexLibApplication {

	@Autowired
	private BookRepository repositorio;

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(GutendexLibApplication.class, args);
	}



	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			Principal menu = new Principal(repositorio, bookService, ctx);
			menu.showMenu();
		};
	}
}
