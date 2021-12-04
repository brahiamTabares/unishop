package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Categoria;
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
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Component
@ViewScoped
@Getter @Setter
public class SubastaBean extends PrimeFacesCrudBean<Subasta,String, SubastaServicio> {



    @Value("#{seguridadBean.usuario}")
    private Usuario usuario;
    private List<Producto> subastas;
    public SubastaBean(SubastaServicio service) {
        super(service);
    }

  /*  @Override
    protected void poblarEntities() {
        setEntities( getService().listar() );
        subastas = getService().obtenerSubastas(usuario.getCodigo());
    }

    public void actualizarFavoritos(Producto producto){
        try {
            if (subastas.contains(producto)) {
                getService().removerSubasta(producto.getCodigo(),usuario.getCodigo());
                subastas.remove(producto);
            } else {
                getService().adicionarSubasta(producto.getCodigo(),usuario.getCodigo());
                subastas.add(producto);
            }
        }catch (Exception e){
            showMessageError(null,"Error: "+e.getMessage());
        }
    }

   public boolean filterByCategoria(Object value, Object filter, Locale locale) {
        Collection<Categoria> categorias = (Collection<Categoria>) value;
        return categorias.stream().map(Categoria::getCodigo).filter(filter::equals).count()>0;


   public void removerSubasta(){
        actualizarSubastas(selectedEntity);
    }*/

}
