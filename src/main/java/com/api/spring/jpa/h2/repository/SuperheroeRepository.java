package com.api.spring.jpa.h2.repository;

import com.api.spring.jpa.h2.model.Superheroe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuperheroeRepository extends JpaRepository<Superheroe, Long> {
  List<Superheroe> findByNombreContainingIgnoreCase(String nombre);
}
