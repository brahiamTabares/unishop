package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Subasta implements Serializable {
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
