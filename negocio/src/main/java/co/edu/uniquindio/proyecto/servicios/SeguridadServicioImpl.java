package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeguridadServicioImpl implements SeguridadServicio{

    private UsuarioRepo usuarioRepo;

    public SeguridadServicioImpl(UsuarioRepo repositorio) {
        this.usuarioRepo = repositorio;

    }

    @Override
    public Usuario autenticar(String username, String password) {
        return usuarioRepo.findByUsername(username)
                .filter(u->u.getPassword().equals(password))
                .orElseThrow( ()->{throw new RuntimeException("Usuario o clave incorrecta");} );
    }
}
