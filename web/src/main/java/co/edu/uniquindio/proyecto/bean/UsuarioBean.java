package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.util.UUID;

@Component
@ViewScoped
@Getter
@Setter
public class UsuarioBean extends PrimeFacesCrudBean<Usuario, String, UsuarioServicio> {


    public UsuarioBean(UsuarioServicio service) {
        super(service);
    }

    public String registrar() {
        try {
            selectedEntity.setCodigo(UUID.randomUUID().toString());
            selectedEntity.setUsername( selectedEntity.getEmail() );
            getService().registrar(selectedEntity);
            showMessageInfo("usuario-bean", "Registro exitoso");
            System.out.println("registro exitoso");
            return "/index?faces-redirect=true";
        } catch (Exception e) {
            showMessageError("usuario-bean", "Error: " + e.getMessage());
            return null;
        }
    }

}
