package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Subasta;
import co.edu.uniquindio.proyecto.repositorios.SubastaRepo;
import org.springframework.stereotype.Service;

@Service
public class SubastaServicioImpl extends ServicioGenerico<Subasta,String, SubastaRepo> implements SubastaServicio{


    public SubastaServicioImpl(SubastaRepo repositorio) {
        super(repositorio);
    }


}
