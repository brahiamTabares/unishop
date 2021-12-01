package co.edu.uniquindio.proyecto.converters;

import co.edu.uniquindio.proyecto.entidades.EntidadGenerica;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

//@FacesConverter(forClass = BaseEntity.class)
public abstract class EntidadConverter<T extends EntidadGenerica<K>,K> implements Converter<T> {
	protected abstract T findById(String id);

	@Override
	public T getAsObject(FacesContext facesContext, UIComponent componente, String id) {
		T entidad = null;
		if (id != null && !"".equals(id.trim())) {
			try {
				//Class<? extends BaseEntity> type = Components.getExpectedValueType(component);
				entidad = findById( id );
			} catch (Exception e) {
				e.printStackTrace();
				throw new ConverterException(
						new FacesMessage( componente.getClientId() + ":" + 	"Error al convertir el elemento"),
						e
				);
			}
		}
		return entidad;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent componente, T entidad) {
		return  entidad != null ? enityToString(entidad) : "";
	}

	protected String enityToString(T entity) {
		return entity.getCodigo().toString();
	}
}