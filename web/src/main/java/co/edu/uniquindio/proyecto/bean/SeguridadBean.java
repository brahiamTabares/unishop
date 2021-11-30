package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.SeguridadServicio;
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
public class SeguridadBean extends AbstracBean implements Serializable {
    private Usuario usuario;
    private boolean autenticado;
    private String email;
    private String password;
    private SeguridadServicio servicio;

    public SeguridadBean(SeguridadServicio servicio) {
        this.servicio = servicio;
    }

    @PostConstruct
    private void inicializar(){

    }

    public String iniciarSesion(){
        try {
            usuario = servicio.autenticar(email, password);
            autenticado = true;
            return "/index?faces-redirect=true";
        }catch (Exception e){
            showMessageError("login-bean",e.getMessage());
            return null;
        }
    }

    public String cerrarSesion() {
        autenticado = false;
        usuario = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }
}
