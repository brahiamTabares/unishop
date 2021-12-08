package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.dto.DatoDTO;
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
public interface UsuarioRepo extends PersonaRepo<Usuario>{

    @Query("select new co.edu.uniquindio.proyecto.dto.DatoDTO(c.nombre,c.usuarios.size) from Ciudad c ")
    List<DatoDTO> numeroUsuariosByCiudad();
}
