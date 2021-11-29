package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicioImpl extends ServicioGenerico<Producto,String, ProductoRepo> implements ProductoServicio{


    public ProductoServicioImpl(ProductoRepo repositorio) {
        super(repositorio);
    }


}
