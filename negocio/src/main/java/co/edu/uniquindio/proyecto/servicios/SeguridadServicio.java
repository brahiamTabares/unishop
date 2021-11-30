package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.entidades.Usuario;

public interface SeguridadServicio {
    Usuario autenticar(String username,String password);
}
