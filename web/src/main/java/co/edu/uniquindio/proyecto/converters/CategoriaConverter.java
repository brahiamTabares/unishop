package co.edu.uniquindio.proyecto.converters;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.servicios.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import javax.faces.convert.FacesConverter;

@Component("categoriaConverter")
//@FacesConverter(value = "categoriaConverter",managed = true)
@RequestScope
@FacesConverter(value = "categoriaConverter",forClass = Categoria.class,managed = true)
public class CategoriaConverter extends EntidadConverter<Categoria,String> {

	@Autowired
	private CategoriaServicio service;

	@Override
	protected Categoria findById(String id) {
		try {
			return service.obtener(id);
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}
}