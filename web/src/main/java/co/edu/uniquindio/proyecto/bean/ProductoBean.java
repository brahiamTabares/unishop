package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
@Getter @Setter
public class ProductoBean extends PrimeFacesCrudBean<Producto,String, ProductoServicio> {

    @Value("#{seguridadBean.usuario}")
    private Usuario usuario;

    public ProductoBean(ProductoServicio service) {
        super(service);
    }

    @Override
    protected void poblarEntities() {
        setEntities( getService().listarByVendedor(usuario.getCodigo()) );
    }

    @Override
    public void save() {
        selectedEntity.setVendedor(usuario);
        super.save();
    }
}
