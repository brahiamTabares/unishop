package co.edu.uniquindio.proyecto.bean.reportes;

import co.edu.uniquindio.proyecto.servicios.ReporteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
public class ProductosPorVendedorBean extends ReporteBean{

    @Autowired
    public ProductosPorVendedorBean(ReporteServicio reporteServicio) {
        super(reporteServicio);
    }

    @PostConstruct
    public void inicializar(){
        label = "Vendedores";
        titulo = "# Productos por Vendedor";
        datos = reporteServicio.generarReporteProductosPorVendedor();
        createBarModel();
    }
}
