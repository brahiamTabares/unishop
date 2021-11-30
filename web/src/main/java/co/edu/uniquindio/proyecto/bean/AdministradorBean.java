package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.servicios.AdministradorServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;

@Component
@ViewScoped
@Getter
@Setter
public class AdministradorBean extends PrimeFacesCrudBean<Administrador,String, AdministradorServicio> {

    public AdministradorBean(AdministradorServicio service) {
        super(service);
    }


}
