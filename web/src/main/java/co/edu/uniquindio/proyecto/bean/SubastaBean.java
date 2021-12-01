package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Subasta;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.SubastaServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;

@Component
@ViewScoped
@Getter @Setter
public class SubastaBean extends PrimeFacesCrudBean<Subasta,String, SubastaServicio> {

    @Value("#{seguridadBean.usuario}")
    private Usuario usuario;

    public SubastaBean(SubastaServicio service) {
        super(service);
    }

}
