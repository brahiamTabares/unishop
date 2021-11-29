package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/*
Las etiquetas siguientes son para que con el @Entity lo reconozca como entidad en la base de dato
Las etiquetas @Getter y œSetter son para tener el còdigo màs limpio, se encarga de generar los getters y setter de la clase
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
/*
Se agrega a cada atributo las respectivas restricciones y sus relaciones con otras entidades
 */
public class Categoria implements Serializable,EntidadGenerica<String> {
    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private  String codigo;
    @Column(nullable = false,length = 50)
    private String nombre;

    @ManyToMany
    @JoinTable (name ="Producto_Categoria", joinColumns = @JoinColumn (name = "codigo_categoria",
            nullable = false), inverseJoinColumns = @JoinColumn (name ="codigo_producto", nullable = false))
        // El inverseJoingColumns define la llave foránea que está ligada con producto
    private List<Producto> productos;

    public Categoria(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Categoria() {

    }
}

