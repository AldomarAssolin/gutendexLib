package com.aldomarassolin.Gutende;

import com.aldomarassolin.Gutende.MainAPP.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class GutendeApplication implements CommandLineRunner {

	public static void main(String[] args){

		SpringApplication.run(GutendeApplication.class, args);

	}

	public void run(String... args){
		Main main = new Main();
		main.showMenu();
	}

}
