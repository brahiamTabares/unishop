package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicioImpl extends ServicioGenerico<Usuario,String,UsuarioRepo> implements UsuarioServicio{


    public UsuarioServicioImpl(UsuarioRepo usuarioRepo) {
        super(usuarioRepo);
    }

    @Override
    public Usuario registrar(Usuario u) throws Exception {
        Optional<Usuario> buscado=repositorio.findByEmail(u.getEmail());
        if(buscado.isPresent()){
            throw new Exception("El email  del usuario ya existe");
        }
        buscado=repositorio.findByUsername(u.getUsername());
        if(buscado.isPresent()){
            throw new Exception("El username  del usuario ya existe");
        }
        return super.registrar(u);
    }


  // se debe crear el metodo obtenerProductosFavoritos
    //@Override
    //public List<Producto> listarFavoritos(String email) {
        //return usuarioRepo.obtenerProductosFavoritos(email);
      //  return
    //}

}
