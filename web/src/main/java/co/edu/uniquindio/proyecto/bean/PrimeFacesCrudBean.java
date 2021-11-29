package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.EntidadGenerica;
import co.edu.uniquindio.proyecto.servicios.EntityServicio;
import org.primefaces.PrimeFaces;

public class PrimeFacesCrudBean<T extends EntidadGenerica<K>,K,S extends EntityServicio<T,K>> extends GenericEntityBean<T,K,S> {

    public PrimeFacesCrudBean(S service) {
        super(service);
    }

    @Override
    public void save() {
        super.save();
        PrimeFaces.current().executeScript("PF('manageEntityDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-entities");
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void delete() {
        super.delete();
        PrimeFaces.current().ajax().update("form:messages", "form:dt-entities");
    }
}
