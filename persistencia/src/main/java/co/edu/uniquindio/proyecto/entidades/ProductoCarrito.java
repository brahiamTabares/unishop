package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ProductoCarrito implements Serializable, EntidadGenerica<String>{

    @Id
    @Column(length = 10)
    @EqualsAndHashCode.Include
    private String codigo;
    @Column(length = 20)
    private String nombre;
     @Column(length = 20)
     private  String imagen;
     @Column(nullable = false)
    private Float precio;
     @Column (nullable = false)
    private Integer unidades;
     @OneToOne
    private Usuario usuario;
     @OneToMany
     private List<Producto> productos;


    public ProductoCarrito() {
        super();
    }



}
