package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.ProductoCarrito;
import co.edu.uniquindio.proyecto.repositorios.ProductoCarritoRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductoCarritoServicioImpl extends ServicioGenerico<ProductoCarrito,String, ProductoCarritoRepo> implements ProductoCarritoServicio{


    public ProductoCarritoServicioImpl(ProductoCarritoRepo repositorio) {
        super(repositorio);
    }


}
