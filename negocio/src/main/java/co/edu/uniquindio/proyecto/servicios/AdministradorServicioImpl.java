package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.AdministradorRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorServicioImpl extends ServicioGenerico<Administrador,String, AdministradorRepo> implements AdministradorServicio{


    public AdministradorServicioImpl(AdministradorRepo repositorio) {
        super(repositorio);
    }



  // se debe crear el metodo obtenerProductosFavoritos
    //@Override
    //public List<Producto> listarFavoritos(String email) {
        //return usuarioRepo.obtenerProductosFavoritos(email);
      //  return
    //}

}
