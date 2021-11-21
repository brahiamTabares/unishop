package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.Entity;

@Entity // la etiqueta es para que la base de datos lo reconozca como entidad

// No se incluyen las anotaciones get, set, ni equals, ya que lo hereda de Persona
public class Administrador extends Persona { // No lleva el serializable porque le llega por herencia

    /*
     Esta clase es una herencia de la clase Persona
     Método constructor
     */

    public Administrador(String codigo, String nombre, String email, String password,String username) {
        super(codigo, nombre, email, password,username);
    }

    public Administrador() {

    }
}
