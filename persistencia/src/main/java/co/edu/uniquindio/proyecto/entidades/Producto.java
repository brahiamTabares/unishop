package co.edu.uniquindio.proyecto.entidades;

import co.edu.uniquindio.proyecto.dto.ProductoCarrito;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
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
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

/*
Se agrega a cada atributo las respectivas restricciones y sus relaciones con otras entidades
 */
public class Producto implements Serializable,EntidadGenerica<String> {
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name ="Producto_Categoria", joinColumns = @JoinColumn (name = "codigo_producto",
            nullable = false), inverseJoinColumns = @JoinColumn (name ="codigo_categoria", nullable = false))
    // El inverseJoingColumns define la llave foránea que está ligada con producto
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

    @OneToMany (mappedBy = "producto")
    private List<Comentario> comentarios;


    public Producto() {
       super();
    }



    public Producto(String codigo, String nombre, Integer unidades, String descripcion, float precio, LocalDate fechaLimite, float descuento, Ciudad ciudad, Usuario vendedor,List<String> imagenes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaLimite = fechaLimite;
        this.descuento = descuento;
        this.ciudad = ciudad;
        this.vendedor = vendedor;
        this.imagenes = imagenes;
    }
}
