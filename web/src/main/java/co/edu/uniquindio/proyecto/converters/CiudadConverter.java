package co.edu.uniquindio.proyecto.converters;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.servicios.CiudadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.faces.convert.FacesConverter;

@Component("ciudadConverter")
@RequestScope
@FacesConverter(value = "ciudadConverter",forClass = Ciudad.class,managed = true)
public class CiudadConverter extends EntidadConverter<Ciudad,String> {

	@Autowired
	private CiudadServicio service;

	@Override
	protected Ciudad findById(String id) {
		try {
			Ciudad ciudad = service.obtener(id);
			System.out.println("La ciudad ----> "+ciudad.getNombre());
			return ciudad;
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}