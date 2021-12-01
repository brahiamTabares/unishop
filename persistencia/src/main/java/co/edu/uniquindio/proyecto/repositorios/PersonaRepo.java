package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepo<T extends Persona> extends JpaRepository<T,String> {
    List<T> findAllByNombreContains(String nombre);
    Optional<T> findByEmail(String email);
    Optional<T>findByEmailAndPassword(String email,String password);
    Optional<T>findByUsernameAndPassword(String username,String password);
    Optional<T>findByUsername(String username);
}
