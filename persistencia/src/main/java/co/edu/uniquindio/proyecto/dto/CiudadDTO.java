package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/*
Las etiquetas siguientes son para que con el @Entity lo reconozca como entidad en la base de dato
Las etiquetas @Getter y œSetter son para tener el còdigo màs limpio, se encarga de generar los getters y setter de la clase
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

/*
Se agrega a cada atributo las respectivas restricciones y sus relaciones con otras entidades
 */
public class CiudadDTO implements Serializable {

    @EqualsAndHashCode.Include
    private String codigo;
    private  String nombre;

    public CiudadDTO() {
    }

    public CiudadDTO(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public static CiudadDTO of(Ciudad ciudad) {
        return new CiudadDTO(ciudad.getCodigo(), ciudad.getNombre());
    }
}
