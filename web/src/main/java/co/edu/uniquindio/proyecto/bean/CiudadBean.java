package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.servicios.CiudadServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;

@Component
@ViewScoped
@Getter
@Setter
public class CiudadBean extends PrimeFacesCrudBean<Ciudad,String, CiudadServicio> {

    public CiudadBean(CiudadServicio service) {
        super(service);
    }


}
