package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;
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
public class Subasta implements Serializable,EntidadGenerica<String> {
    @Id
    @Column(nullable = false,length = 10)
    @EqualsAndHashCode.Include
    private String codigo;
    @Future
    @Column(name="fecha_limite", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn (name="codigo_producto", nullable = false)
    private Producto producto;

    @OneToMany (mappedBy = "subasta")
    private List<SubastaUsuario> subastaUsuarios;

    public Subasta() {
     super();
    }

    public Subasta(String codigo, LocalDate fecha, Producto producto) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.producto = producto;
    }

}
