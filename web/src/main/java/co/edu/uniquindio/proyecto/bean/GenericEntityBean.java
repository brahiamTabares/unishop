package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.EntidadGenerica;
import co.edu.uniquindio.proyecto.servicios.EntityServicio;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericEntityBean<T extends EntidadGenerica<K>,K,S extends EntityServicio<T,K>> extends AbstracBean {
    protected T selectedEntity;
    private final S service;
    private final Class<T> type;
    private List<T> entities;
    private List<T> selectedEntities;
    protected boolean updating = false;

    public GenericEntityBean(S service){
        this.service = service;
        type = findGenericType(0);
    }

    private Class<T> findGenericType(int index) {
        Class<?> klass = getClass();
        while (klass.getSuperclass() != null && (!(klass.getGenericSuperclass() instanceof ParameterizedType) || !( ((ParameterizedType)klass
                .getGenericSuperclass()).getActualTypeArguments()[index] instanceof Class ) ) ) {
            klass = klass.getSuperclass();
        }
        return (Class<T>) ((ParameterizedType)klass.getGenericSuperclass()).getActualTypeArguments()[index];
    }

    @PostConstruct
    public void initialize(){
        entities = service.listar();
        newEntity();
    }

    public void newEntity() {
        try {
            selectedEntity = type.getConstructor().newInstance();
            updating = false;
        } catch (Exception e) {
            showMessageError(null,"Error inesperado en el servidor");
        }
    }

    public void save(){
        if( updating ){
            update();
        } else {
            create();
        }
    }
    public void create(){
        try {
            service.registrar(selectedEntity);
            entities.add(selectedEntity);
            showMessageInfo(null,"Operación exitosa");
        }catch (Exception e){
            showMessageError(null,"No se pudo completar la operación");
        }
    }

    public void update(){
        try {
            service.actualizar(selectedEntity);
            showMessageInfo(null,"Operación exitosa");
        }catch (Exception e){
            showMessageError(null,"No se pudo completar la operación");
        }
    }

    public void delete(){
        try {
            service.eliminar(selectedEntity.getCodigo());
            entities.remove(selectedEntity);
            selectedEntity = null;
            showMessageInfo(null,"Operación exitosa");
        }catch (Exception e){
            showMessageError(null,"No se pudo completar la operación");
        }
    }


    protected S getService() {
        return service;
    }

    public T getSelectedEntity() {
        return selectedEntity;
    }

    public void setSelectedEntity(T selectedEntity) {
        this.selectedEntity = selectedEntity;
        updating = true;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }

    public List<T> getSelectedEntities() {
        return selectedEntities;
    }

    public void setSelectedEntities(List<T> selectedEntities) {
        this.selectedEntities = selectedEntities;
    }

    public boolean isUpdating() {
        return updating;
    }
}
