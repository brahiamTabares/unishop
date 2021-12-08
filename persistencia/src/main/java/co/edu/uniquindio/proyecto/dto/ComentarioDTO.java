package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Comentario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
Las etiquetas siguientes son para que con el @Entity lo reconozca como entidad en la base de dato
Las etiquetas @Getter y œSetter son para tener el còdigo màs limpio, se encarga de generar los getters y setter de la clase
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

/*
Se agrega a cada atributo las respectivas restricciones y sus relaciones con otras entidades
 */
public class ComentarioDTO implements Serializable {
    @EqualsAndHashCode.Include
    private  String codigo;
    private String  mensaje;
    private String respuesta;
   // el name="fecha_comentario", indica que en base de datos asì es como se va a llamar la columna
    private LocalDateTime fechaComentario;
    private Integer calificacion;
    private UsuarioDTO usuario;

    public ComentarioDTO() {
     super();
    }

    public ComentarioDTO(String codigo, String mensaje, String respuesta, LocalDateTime fechaComentario, Integer calificacion, UsuarioDTO usuario) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.respuesta = respuesta;
        this.fechaComentario = fechaComentario;
        this.calificacion = calificacion;
        this.usuario = usuario;
    }

    public static ComentarioDTO of(Comentario comentario) {
        return new ComentarioDTO(comentario.getCodigo(), comentario.getMensaje(), comentario.getRespuesta(),comentario.getFechaComentario(), comentario.getCalificacion(), UsuarioDTO.of(comentario.getUsuario()));
    }
}
