package co.edu.uniquindio.proyecto.entidades;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @Column(nullable = false,length=50)
     private String nombre;
    @Positive
    @Column(nullable = false)
     private Integer unidades;
    @Column(length = 210)
     private String descripcion;
    @Positive
    @Column(nullable = false)
     private float   precio;
    @Column(name="fecha_limite", nullable = false)
     private LocalDate fechaLimite;
    @Positive
    private float descuento;
    @ManyToMany(mappedBy = "productos")
    private List<Categoria> categorias;
    @ManyToOne
    @JoinColumn (name="codigo_ciudad")
    private Ciudad ciudad;
    @OneToMany (mappedBy = "producto")
    private List<DetalleCompra> detallesCompra;
    @ManyToOne
    @JoinColumn (name = "codigo_vendedor")
    private Usuario vendedor;
    @ElementCollection
    @CollectionTable (name = "Imagen",joinColumns = @JoinColumn(name = "codigo_producto"))// Para poder definir el nombre de la tabla que va a almacenar las rutas
    @Column (name = "ruta")
    private List<String> imagenes;
    @ManyToMany
    @JoinTable (name = "Favorito", joinColumns = @JoinColumn (name = "codigo_producto", nullable = false),
            inverseJoinColumns = @JoinColumn (name ="codigo_usuario", nullable = false))
            // Define la tabla intermedia Favorito con las llaves foráneas
    private List<Usuario> usuarios;

    @OneToMany (mappedBy = "producto")
    private List<Subasta> subastas;


    public Producto() {
       super();
    }

}
