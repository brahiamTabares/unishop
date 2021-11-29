package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ProductoCarrito implements Serializable, EntidadGenerica<String>{

    @EqualsAndHashCode.Include
    @Id
    private String codigo;
    private String nombre,imagen;
    private Float precio;
    private Integer unidades;
}
