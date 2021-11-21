package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,String>{

/*
    @Query(select u from Usuario u where u.nombre = :nombre);
    List<Usuario>obtenerUsuariosPorNombre(String nombre);
*/
    //Trae la lista con los nombre
    List<Usuario>findAllByNombreContains(String nombre);
    // Trae uno solo
    Optional<Usuario>findByEmail(String email);
    Optional<Usuario>findByEmailAndPassword(String email,String password);
    Optional<Usuario>findByUsername(String username);

    @Override
    Page<Usuario> findAll(Pageable paginador);
}
