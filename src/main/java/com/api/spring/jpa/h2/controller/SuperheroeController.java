package com.api.spring.jpa.h2.controller;

import java.util.List;
import java.util.Optional;

import com.api.spring.jpa.h2.model.Superheroe;
import com.api.spring.jpa.h2.service.SuperheroeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SuperheroeController {

  private final SuperheroeService service;

  protected SuperheroeController(SuperheroeService service) {
      this.service = service;
  }

  @GetMapping("/superheroes")
  public ResponseEntity<List<Superheroe>> getAll(@RequestParam(required = false) String nombre) {
    try {
      List<Superheroe> superheroes = service.getAllSuperheroes(nombre);

      if (superheroes.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(superheroes, HttpStatus.OK);

    } catch (Exception ex) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/superheroes/{id}")
  public ResponseEntity<Superheroe> getById(@PathVariable("id") long id) {
    try {
      Optional<Superheroe> superheroesData = service.getSuperheroeById(id);

      if (superheroesData.isPresent()) {
        return new ResponseEntity<>(superheroesData.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (Exception ex) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

   @PostMapping("/superheroes")
   public ResponseEntity<Superheroe> createSuperheroe(@RequestBody Superheroe superheroe) {
     try {
       return new ResponseEntity<>(service.saveSuperheroe(superheroe), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/superheroes/{id}")
  public ResponseEntity<Superheroe> changeSuperheroe(@PathVariable("id") long id, @RequestBody Superheroe superheroe) {
    try {
      return new ResponseEntity<>(service.updateSuperheroe(id, superheroe), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/superheroes/{id}")
  public ResponseEntity<HttpStatus> deleteSuperheroe(@PathVariable("id") long id) {
    try {
      service.deleteSuperheroeById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
