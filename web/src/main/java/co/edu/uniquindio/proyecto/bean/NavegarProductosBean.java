package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.ComentarioServicio;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Component
@ViewScoped
@Getter @Setter
public class NavegarProductosBean extends PrimeFacesCrudBean<Producto,String, ProductoServicio> {

    @Value("#{seguridadBean.usuario}")
    private Usuario usuario;
    private ComentarioServicio comentarioServicio;
    private List<Producto> favoritos;
    private List<Comentario> comentarios;
    private Comentario comentario;

    public NavegarProductosBean(ProductoServicio service, ComentarioServicio comentarioServicio) {
        super(service);
        this.comentarioServicio = comentarioServicio;
        //this.usuario = (Usuario) seguridadBean.getUsuario();
    }

    @Override
    protected void poblarEntities() {
        setEntities( getService().listar() );
        favoritos = getService().obtenerFavoritos(usuario.getCodigo());
    }

    public void actualizarFavoritos(Producto producto){
        try {
            if (favoritos.contains(producto)) {
                getService().removerFavorito(producto.getCodigo(),usuario.getCodigo());
                favoritos.remove(producto);
            } else {
                getService().adicionarFavorito(producto.getCodigo(),usuario.getCodigo());
                favoritos.add(producto);
            }
        }catch (Exception e){
            showMessageError(null,"Error: "+e.getMessage());
        }
    }

    public boolean filterByCategoria(Object value, Object filter, Locale locale) {
        Collection<Categoria> categorias = (Collection<Categoria>) value;
        return categorias.stream().map(Categoria::getCodigo).filter(filter::equals).count()>0;
    }

    public void removerFavorito(){
        actualizarFavoritos(selectedEntity);
    }

    public void newComentario(String productoCodigo){
        try{
            comentario = comentarioServicio.obtener(productoCodigo+"-"+usuario.getCodigo());
        }catch (Exception e){
            comentario = new Comentario();
            comentario.setCodigo(productoCodigo+"-"+usuario.getCodigo() );
        }
    }

    public void cargarComentarios(String codigo){
        comentarios = comentarioServicio.obtenerComentarios(codigo);
    }

    public void saveComentario(){
        try {
            if (comentario.getFechaComentario() != null) {
                comentarioServicio.actualizar(comentario);
            } else {
                comentario.setProducto(selectedEntity);
                comentario.setUsuario(usuario);
                comentario.setFechaComentario(LocalDateTime.now());
                comentarioServicio.registrar(comentario);
            }
        }catch (Exception e){
            showMessageError(null,"Error: "+e.getMessage());
        }

    }


}
