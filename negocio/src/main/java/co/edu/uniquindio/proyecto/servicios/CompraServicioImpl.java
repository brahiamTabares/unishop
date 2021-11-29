package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import org.springframework.stereotype.Service;

@Service
public class CompraServicioImpl extends ServicioGenerico<Compra,String, CompraRepo> implements CompraServicio{


    public CompraServicioImpl(CompraRepo repositorio) {
        super(repositorio);
    }


}
