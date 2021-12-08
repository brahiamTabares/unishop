package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.DatoDTO;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteServicioImpl implements ReporteServicio{

    private ProductoRepo productoRepo;
    private UsuarioRepo usuarioRepo;
    private CompraRepo compraRepo;

    @Autowired
    public ReporteServicioImpl(ProductoRepo productoRepo, UsuarioRepo usuarioRepo, CompraRepo compraRepo) {
        this.productoRepo = productoRepo;
        this.usuarioRepo = usuarioRepo;
        this.compraRepo = compraRepo;
    }



    @Override
    public List<DatoDTO> generarReporteProductosPorVendedor() {
        return productoRepo.numeroProductosByVendedor();
    }

    @Override
    public List<DatoDTO> generarReporteProductosPorCategoria() {
        return productoRepo.numeroProductosByCategoria();
    }

    @Override
    public List<DatoDTO> generarReporteProductosPorCiudad() {
        return productoRepo.numeroProductosByCiudad();
    }

    @Override
    public List<DatoDTO> generarReporteUsuariosPorCiudad() {
        return usuarioRepo.numeroUsuariosByCiudad();
    }

    @Override
    public List<DatoDTO> generarReporteComprasPorMedioPago() {
        return compraRepo.numeroComprasByMedioPago();
    }
}
