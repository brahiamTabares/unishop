package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.servicios.CategoriaServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;

@Component
@ViewScoped
@Getter
@Setter
public class CategoriaBean extends PrimeFacesCrudBean<Categoria,String, CategoriaServicio> {

    public CategoriaBean(CategoriaServicio service) {
        super(service);
    }


}
