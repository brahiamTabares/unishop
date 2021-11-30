package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.EntidadGenerica;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ProductoCarrito implements Serializable, EntidadGenerica<String> {

    @EqualsAndHashCode.Include
    private String codigo;
    private String nombre;
    private String imagen;
    private Float precio;
    private Integer unidades;
    public ProductoCarrito() {
        super();
    }

}
