package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Comentario;

import java.util.List;

public interface ComentarioServicio extends EntityServicio<Comentario,String>{
    List<Comentario> obtenerComentarios(String codigo);
}
