package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.repositorios.CategoriaRepo;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServicioImpl extends ServicioGenerico<Categoria,String, CategoriaRepo> implements CategoriaServicio{


    public CategoriaServicioImpl(CategoriaRepo repositorio) {
        super(repositorio);
    }





}
