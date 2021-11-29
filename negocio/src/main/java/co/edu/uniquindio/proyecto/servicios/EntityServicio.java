package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.EntidadGenerica;

import java.util.List;

//Interfaz generica
public interface EntityServicio<T extends EntidadGenerica<K>,K> {
//T es para el tipo de la entidad correspondiente
// K es para el tipo de dato de la llave

    T registrar(T entidad) throws  Exception;

    T actualizar(T entidad) throws Exception;

    void eliminar(K codigo) throws Exception;

    List<T> listar();

    T obtener(K codigo) throws  Exception;

}
