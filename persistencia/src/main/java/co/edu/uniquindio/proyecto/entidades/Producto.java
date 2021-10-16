package co.edu.uniquindio.proyecto.entidades;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {
    @Id
    @Column(nullable = false,length = 10)
    @EqualsAndHashCode.Include
     private String codigo;
    @Column(nullable = false,length=100)
     private String nombre;
    @Positive
    @Column(nullable = false)
     private Integer unidades;
    @Column(length = 210)
     private String descripcion;
    @Positive
    @Column(nullable = false)
     private float   precio;
    @Column(nullable = false)
     private LocalDate fecha_Limite;
    @ManyToMany(mappedBy = "productos")
    private List<Categoria> categorias;

    public Producto() {
       super();
    }

}
