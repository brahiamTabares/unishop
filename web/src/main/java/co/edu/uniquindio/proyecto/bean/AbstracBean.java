package co.edu.uniquindio.proyecto.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

public abstract class AbstracBean implements Serializable {

    protected FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    protected void showMessage(String idComponente, String message, FacesMessage.Severity severidad) {
        FacesMessage facesMessage = new FacesMessage(severidad, message, message);
        if( getFacesContext() != null ) {
            getFacesContext().addMessage(idComponente, facesMessage);
        }
    }

    protected void showMessageInfo(String idComponente, String mensaje) {
        showMessage(idComponente, mensaje, FacesMessage.SEVERITY_INFO);
    }

    protected void showMessageError(String idComponente, String mensaje) {
        showMessage(idComponente, mensaje, FacesMessage.SEVERITY_ERROR);
    }
}
