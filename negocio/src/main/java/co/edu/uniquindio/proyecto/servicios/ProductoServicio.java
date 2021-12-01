package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Producto;

import java.util.List;

public interface ProductoServicio extends EntityServicio<Producto,String>{
    List<Producto> listarByVendedor(String codigo);
    List<Producto> obtenerFavoritos(String codigo);

    void removerFavorito(String codigoProducto, String codigoUsuario) throws Exception;

    void adicionarFavorito(String codigoProducto, String codigoUsuario) throws Exception;
}
