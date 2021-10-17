package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.Entity;

@Entity
// No se incluyen las anotaciones get, set, ni equals, ni constructor ya que lo hereda de Persona
public class Administrador extends Persona { // No lleva el serializable porque le llega por herencia


}
