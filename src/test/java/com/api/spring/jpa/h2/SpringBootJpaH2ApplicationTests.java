package com.api.spring.jpa.h2;

import com.api.spring.jpa.h2.model.Superheroe;
import com.api.spring.jpa.h2.repository.SuperheroeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class SpringBootJpaH2ApplicationTests {

	@Autowired
	private SuperheroeRepository superheroeRepository;

	@Test
	void contextLoads() {
		Assert.notNull(superheroeRepository, "Repository is null");
	}

	@Test
	public void seCreanYalmacenanSuperheroes() {

		Superheroe mock1 = new Superheroe("Flash", "El ser más rápido del universo");
		Superheroe mock2 = new Superheroe("Wonderwoman", "La mujer maravilla");
		Superheroe mock3 = new Superheroe("Lobezno", "El tio duro de las garras");
		Superheroe mock4 = new Superheroe("Eduardo Manostijeras", "El que está en otro mundo");
		superheroeRepository.deleteAll();
		superheroeRepository.save(mock1);
		superheroeRepository.save(mock2);
		superheroeRepository.save(mock3);
		superheroeRepository.save(mock4);
		List<Superheroe> superheroes = superheroeRepository.findAll();
		Assert.notNull(mock1, "No se ha creado el superheroe");
		Assert.notEmpty (superheroes, "No se han guardado superheroes");
		Assert.isTrue(superheroes.size() == 4, "No sean guardado los 3 que se han creado, ahora hay: " + superheroes.size());
	}
}
