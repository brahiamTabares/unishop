package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Chat;
import co.edu.uniquindio.proyecto.repositorios.ChatRepo;
import org.springframework.stereotype.Service;

@Service
public class ChatServicioImpl extends ServicioGenerico<Chat,String, ChatRepo> implements ChatServicio{


    public ChatServicioImpl(ChatRepo repositorio) {
        super(repositorio);
    }


}
