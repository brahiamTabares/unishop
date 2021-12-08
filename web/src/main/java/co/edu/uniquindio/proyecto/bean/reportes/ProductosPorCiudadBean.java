package co.edu.uniquindio.proyecto.bean.reportes;

import co.edu.uniquindio.proyecto.servicios.ReporteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
public class ProductosPorCiudadBean extends ReporteBean{

    @Autowired
    public ProductosPorCiudadBean(ReporteServicio reporteServicio) {
        super(reporteServicio);
    }

    @PostConstruct
    public void inicializar(){
        label = "Ciudad";
        titulo = "# Productos por Ciudad";
        datos = reporteServicio.generarReporteProductosPorCiudad();
        createBarModel();
    }
}
