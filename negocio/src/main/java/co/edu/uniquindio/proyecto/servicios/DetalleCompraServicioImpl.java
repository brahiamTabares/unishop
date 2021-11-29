package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import org.springframework.stereotype.Service;

@Service
public class DetalleCompraServicioImpl extends ServicioGenerico<DetalleCompra,String, DetalleCompraRepo> implements DetalleCompraServicio{


    public DetalleCompraServicioImpl(DetalleCompraRepo repositorio) {
        super(repositorio);
    }


}
