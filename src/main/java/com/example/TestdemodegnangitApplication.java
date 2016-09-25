package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;

import java.util.Random;

@SpringBootApplication
public class TestdemodegnangitApplication {

	public static void main(String[] args) {

        Random random = new Random();
		SpringApplication.run(TestdemodegnangitApplication.class, args);



        System.out.println( random.nextFloat());


	}





}
