package com.example.Linhui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
//	@EnableWebMvc
public class BookApiApplication{

	private Book book;


	public static void main(String[] args) {
		SpringApplication.run(BookApiApplication.class, args);

		// ArrayList<Book> data = new ArrayList<Book>();

		// Book v1 = new Book("Shibumi", "Trevanian", "12", 1979, "Thriller");




	}



}


/*
@Bean
public class CommandLineRunner commandLineRunner(ApplicationContext ctx){
	return args -> {

		System.out.println("Let's see what the Bean returns to us!");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for(String beanName: beanNames){
			System.out.println(beanName);
	}
}
}
*/
