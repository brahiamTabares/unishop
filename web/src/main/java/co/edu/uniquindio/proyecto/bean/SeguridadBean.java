package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@SessionScope
@Getter
@Setter
public class SeguridadBean implements Serializable {
    private Usuario usuario;
    private boolean autenticado;
    private String email;
    private String password;

    @PostConstruct
    private void inicializar(){

    }

    public void iniciarSession(){

    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }
}
