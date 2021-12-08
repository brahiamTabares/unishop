package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.DatoDTO;
import co.edu.uniquindio.proyecto.entidades.Subasta;

import java.util.List;

public interface ReporteServicio {
    List<DatoDTO> generarReporteProductosPorVendedor();

    List<DatoDTO> generarReporteProductosPorCategoria();

    List<DatoDTO> generarReporteProductosPorCiudad();

    List<DatoDTO> generarReporteUsuariosPorCiudad();

    List<DatoDTO> generarReporteComprasPorMedioPago();
}
