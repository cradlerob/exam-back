package com.mifel.exam;

import com.mifel.exam.encrypter.controller.EncryptController;
import com.mifel.exam.encrypter.service.EncryptService;
import com.mifel.exam.persons.controller.Controller;
import com.mifel.exam.persons.service.impl.PersonServiceImpl;
import com.mifel.exam.pokemon.controller.PokemonController;
import com.mifel.exam.pokemon.service.PokemonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackageClasses = {Controller.class, PokemonController.class, EncryptController.class, PersonServiceImpl.class, PokemonService.class, EncryptService.class})
public class ExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}

}
