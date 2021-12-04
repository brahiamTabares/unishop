package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl extends ServicioGenerico<Producto,String, ProductoRepo> implements ProductoServicio{

    private UsuarioServicio usuarioServicio;

    public ProductoServicioImpl(ProductoRepo repositorio,UsuarioServicio usuarioServicio) {
        super(repositorio);
        this.usuarioServicio = usuarioServicio;
    }

    @Override
    public List<Producto> listarByVendedor(String codigo) {
        return repositorio.findAllByVendedor(codigo);
    }

    @Override
    public List<Producto> obtenerFavoritos(String codigo) {
        return repositorio.obtenerFavoritos(codigo);
    }

/*    @Override
    public List<Producto> obtenerSubastas(String codigo) {
        return repositorio.obtenerSubastas(codigo);
    }

*/
    @Override
    public void adicionarFavorito(String codigoProducto, String codigoUsuario) throws Exception {
        Optional<Producto> producto = repositorio.findById(codigoProducto);
        Usuario usuario = usuarioServicio.obtener(codigoUsuario);
        if( producto.isPresent() && usuario != null  ){
            producto.get().getUsuarios().add( usuario );
            actualizar(producto.get());
            usuario.getProductosFavoritos().add(producto.get());
            usuarioServicio.actualizar(usuario);
        } else {
            throw new Exception("Error: Producto no encontrado");
        }
    }

    @Override
    public void removerSubasta(String codigoProducto, String codigoUsuario) throws Exception {

    }

    @Override
    public void adicionarSubasta(String codigoProducto, String codigoUsuario) throws Exception {

    }

    @Override
    public void removerFavorito(String codigoProducto, String codigoUsuario) throws Exception {
        Optional<Producto> producto = repositorio.findById(codigoProducto);
        Usuario usuario = usuarioServicio.obtener(codigoUsuario);
        if( producto.isPresent() && usuario != null  ){
            producto.get().getUsuarios().remove( usuario );
            actualizar(producto.get());
            usuario.getProductosFavoritos().remove(producto.get());
            usuarioServicio.actualizar(usuario);
        } else {
            throw new Exception("Error: Producto no encontrado");
        }
    }
}
