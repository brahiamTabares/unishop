package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Categoria {
    @Id
    private  String codigo;
    private String nombre;

}
