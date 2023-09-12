package com.api.spring.jpa.h2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "superheroes")
public class Superheroe {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "descripcion")
  private String descripcion;

  public Superheroe() {

  }

  public Superheroe(String nombre, String descripcion) {
    this.nombre = nombre;
    this.descripcion = descripcion;
  }

  public long getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public String toString() {
    return "Superheroe [id=" + id + ", nombre=" + nombre + ", desc=" + descripcion + "]";
  }
}
