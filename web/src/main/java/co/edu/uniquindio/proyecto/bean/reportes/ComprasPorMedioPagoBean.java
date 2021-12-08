package co.edu.uniquindio.proyecto.bean.reportes;

import co.edu.uniquindio.proyecto.servicios.ReporteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
public class ComprasPorMedioPagoBean extends ReporteBean{

    @Autowired
    public ComprasPorMedioPagoBean(ReporteServicio reporteServicio) {
        super(reporteServicio);
    }

    @PostConstruct
    public void inicializar(){
        label = "Medio de Pago";
        titulo = "# Compras por Medio de Pago";
        datos = reporteServicio.generarReporteComprasPorMedioPago();
        createBarModel();
    }
}
