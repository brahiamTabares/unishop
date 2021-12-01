package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServicioImpl extends ServicioGenerico<Comentario,String, ComentarioRepo> implements ComentarioServicio{


    public ComentarioServicioImpl(ComentarioRepo repositorio) {
        super(repositorio);
    }


    @Override
    public List<Comentario> obtenerComentarios(String codigo) {
        return repositorio.obtenerComentarios(codigo);
    }
}
