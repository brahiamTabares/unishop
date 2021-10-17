package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Comentario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private  String codigo;
    @Column(nullable = false,length = 210)
    private String  mensaje;
    @Column(nullable = false,length = 210)
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
}
