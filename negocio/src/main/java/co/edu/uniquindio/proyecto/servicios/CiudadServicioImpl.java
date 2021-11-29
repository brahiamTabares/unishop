package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import org.springframework.stereotype.Service;

@Service
public class CiudadServicioImpl extends ServicioGenerico<Ciudad,String, CiudadRepo> implements CiudadServicio{


    public CiudadServicioImpl(CiudadRepo repositorio) {
        super(repositorio);
    }


}
