package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.repositorios.PersonaRepo;
import org.springframework.stereotype.Service;

@Service
public class SeguridadServicioImpl implements SeguridadServicio{

    private PersonaRepo<Persona> personaRepo;

    public SeguridadServicioImpl(PersonaRepo<Persona> repositorio) {
        this.personaRepo = repositorio;
    }

    @Override
    public Persona autenticar(String username, String password) {
        return personaRepo.findByUsernameAndPassword(username,password)
                .orElseThrow( ()->{throw new RuntimeException("Usuario o clave incorrecta");} );
    }

}
