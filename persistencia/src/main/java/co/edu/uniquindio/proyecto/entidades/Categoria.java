package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria implements Serializable {
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

    public Categoria() {
        super();
    } // No es necesario tener el constructo ya que por
    // defecto toda clase tiene un constructor sin parámtros mientras no se defina ningún otro.
}

