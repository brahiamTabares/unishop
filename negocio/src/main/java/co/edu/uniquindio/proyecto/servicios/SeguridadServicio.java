package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Persona;

public interface SeguridadServicio {
    Persona autenticar(String username,String password) ;
}
