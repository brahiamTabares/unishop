package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private String codigo;
    @Column(nullable = false,length = 50)
    private  String nombre;
    @OneToMany (mappedBy = "ciudad") // La relación ya existe en Usuario a travès de la variable ciudad
    private List<Usuario> usuarios;
    @OneToMany (mappedBy = "ciudad")
    private List<Producto> productos;

    public Ciudad() {
    }

    public Ciudad(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
