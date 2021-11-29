package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Envio;
import co.edu.uniquindio.proyecto.repositorios.EnvioRepo;
import org.springframework.stereotype.Service;

@Service
public class EnvioServicioImpl extends ServicioGenerico<Envio,String, EnvioRepo> implements EnvioServicio{


    public EnvioServicioImpl(EnvioRepo repositorio) {
        super(repositorio);
    }


}
