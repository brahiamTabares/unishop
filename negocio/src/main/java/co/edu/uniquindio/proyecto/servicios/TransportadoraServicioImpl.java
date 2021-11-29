package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Transportadora;
import co.edu.uniquindio.proyecto.repositorios.TransportadoraRepo;
import org.springframework.stereotype.Service;

@Service
public class TransportadoraServicioImpl extends ServicioGenerico<Transportadora,String, TransportadoraRepo> implements TransportadoraServicio{


    public TransportadoraServicioImpl(TransportadoraRepo repositorio) {
        super(repositorio);
    }


}
