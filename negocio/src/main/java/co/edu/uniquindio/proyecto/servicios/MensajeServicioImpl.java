package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Mensaje;
import co.edu.uniquindio.proyecto.repositorios.MensajeRepo;
import org.springframework.stereotype.Service;

@Service
public class MensajeServicioImpl extends ServicioGenerico<Mensaje,String, MensajeRepo> implements MensajeServicio{


    public MensajeServicioImpl(MensajeRepo repositorio) {
        super(repositorio);
    }


}
