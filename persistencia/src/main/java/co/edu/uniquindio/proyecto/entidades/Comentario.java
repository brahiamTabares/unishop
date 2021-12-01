package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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
public class Comentario implements Serializable,EntidadGenerica<String> {
    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 50)
    private  String codigo;
    @Column(nullable = false,length = 210)
    private String  mensaje;
    @Column(length = 210)
    private String respuesta;
    @Column(name="fecha_comentario",nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
   // el name="fecha_comentario", indica que en base de datos asì es como se va a llamar la columna
    private LocalDateTime fechaComentario;
    @Column(nullable = false)
    private Integer calificacion;
    @ManyToOne
    @JoinColumn (name = "codigo_usuario",nullable = false) // el nullable es porque no tiene sentido un comentario sin usuario
    private Usuario usuario;
    @ManyToOne
    @JoinColumn (name="codigo_producto",nullable = false)// El nullable es porque no tiene sentido un comentario sin producto
    private Producto producto;

    public Comentario() {
     super();
    }

    public Comentario(String codigo, String mensaje, String respuesta, LocalDateTime fechaComentario, Integer calificacion, Usuario usuario, Producto producto) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.respuesta = respuesta;
        this.fechaComentario = fechaComentario;
        this.calificacion = calificacion;
        this.usuario = usuario;
        this.producto = producto;
    }
}
