package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ProductoCarrito implements Serializable, EntidadGenerica<String>{

    @EqualsAndHashCode.Include
    private String codigo;
    private String nombre,imagen;
    private Float precio;
    private Integer unidades;
}
