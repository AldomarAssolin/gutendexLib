package com.aldomarassolin;

import com.aldomarassolin.MainAPP.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class GutendeLibApplication implements CommandLineRunner {

	public static void main(String[] args){

		SpringApplication.run(com.aldomarassolin.GutendeLibApplication.class, args);

	}

	public void run(String... args){
		Main main = new Main();
		main.showMenu();
	}

}
