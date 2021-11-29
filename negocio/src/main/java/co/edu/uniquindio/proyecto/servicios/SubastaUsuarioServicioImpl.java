package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.SubastaUsuario;
import co.edu.uniquindio.proyecto.repositorios.SubastaUsuarioRepo;
import org.springframework.stereotype.Service;

@Service
public class SubastaUsuarioServicioImpl extends ServicioGenerico<SubastaUsuario,String, SubastaUsuarioRepo> implements SubastaUsuarioServicio{


    public SubastaUsuarioServicioImpl(SubastaUsuarioRepo repositorio) {
        super(repositorio);
    }


}
