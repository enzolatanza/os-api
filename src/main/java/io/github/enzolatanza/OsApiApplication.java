package io.github.enzolatanza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//implements CommandineRunner -> implementa um codigo sempre que a aplicação subir
@SpringBootApplication
public class OsApiApplication { //implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(OsApiApplication.class, args);
	}
	/*
	@Override
	public void run(String... args) throws Exception {

		
	}
	*/

}
