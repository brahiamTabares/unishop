package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.EntidadGenerica;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ProductoCarrito implements Serializable, EntidadGenerica<String> {

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
     @ManyToMany
     private List<Producto> productos;


    public ProductoCarrito() {
        super();
    }



}
