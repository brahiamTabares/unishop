package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.EntidadGenerica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//T es para el tipo de la entidad correspondiente e implementa entidad genérica (declarando que tiene el mètodo getCodigo)
// K es para el tipo de dato de la llave
// R es el Repositorio
public class ServicioGenerico<T extends EntidadGenerica<K>,K,R extends JpaRepository<T,K>> implements EntityServicio<T,K>{
    protected final R repositorio;

    public ServicioGenerico(R repositorio) {
        this.repositorio = repositorio;
    }

    protected R getRepositorio(){
        return repositorio;
    }

    @Override
    public T registrar(T entidad) throws Exception {
        Optional<T> buscado= repositorio.findById(entidad.getCodigo());
        if(buscado.isPresent()){
            throw new Exception("El codigo  del usuario ya existe");
        }
        return  repositorio.save(entidad);
    }

    @Override
    public T actualizar(T entidad) throws Exception {
        return repositorio.save(entidad);
    }

    @Override
    public void eliminar(K codigo) throws Exception {
        repositorio.deleteById(codigo);
    }

    @Override
    public List<T> listar() {
        return repositorio.findAll();
    }

    @Override
    public T obtener(K codigo) throws Exception {
        Optional<T> buscado=repositorio.findById(codigo);
        if(buscado.isEmpty()){
            throw new Exception("El codigo  del registro  no existe");
        }
        return  buscado.get();
    }
}
