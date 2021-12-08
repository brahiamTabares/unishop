package co.edu.uniquindio.proyecto.bean.reportes;

import co.edu.uniquindio.proyecto.servicios.ReporteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
public class UsuariosPorCiudadBean extends ReporteBean{

    @Autowired
    public UsuariosPorCiudadBean(ReporteServicio reporteServicio) {
        super(reporteServicio);
    }

    @PostConstruct
    public void inicializar(){
        label = "Ciudad";
        titulo = "# Usuarios por Ciudad";
        datos = reporteServicio.generarReporteUsuariosPorCiudad();
        createBarModel();
    }
}
