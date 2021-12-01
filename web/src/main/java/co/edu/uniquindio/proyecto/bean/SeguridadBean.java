package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Persona;
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
@Getter @Setter
public class SeguridadBean extends AbstracBean implements Serializable {
    private Persona usuario;
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

    public boolean isUser(){
        return usuario instanceof Usuario;
    }

    public boolean isAdministrador(){
        return usuario instanceof Administrador;
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

    public void recuperar(){
        try {
            servicio.recuperar(email);
            showMessageInfo("recuperar-bean","Correo enviado");
        }catch (Exception e){
            showMessageError("recuperar-bean",e.getMessage());
        }
    }

    public String cerrarSesion() {
        autenticado = false;
        usuario = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }

    public String getRol(){
        return usuario != null && autenticado ? usuario.getClass().getSimpleName() : "";
    }
}
