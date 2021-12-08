package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/*
Las etiquetas siguientes son para que con el @Entity lo reconozca como entidad en la base de dato
Las etiquetas @Getter y œSetter son para tener el còdigo màs limpio, se encarga de generar los getters y setter de la clase
 */
@Getter
@Setter

/*
Se agrega a cada atributo las respectivas restricciones y sus relaciones con otras entidades
 */
public class UsuarioDTO extends PersonaDTO { // No requiere serializable por venir de Herencia

    private CiudadDTO ciudad;
    private List<String> telefonos;

    public UsuarioDTO() {
        super();
    }

    public UsuarioDTO(String codigo, String nombre, String email, String username, CiudadDTO ciudad, List<String> telefonos) {
        super(codigo, nombre, email, username);
        this.ciudad = ciudad;
        this.telefonos = telefonos;
    }

    public static UsuarioDTO of(Usuario usuario) {
        return new UsuarioDTO(usuario.getCodigo(), usuario.getNombre(), usuario.getEmail(), usuario.getUsername(), CiudadDTO.of(usuario.getCiudad()),usuario.getTelefonos());
    }
}
