package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.ChatRepo;
import co.edu.uniquindio.proyecto.repositorios.MensajeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class mensajeTest {

     @Autowired
    private MensajeRepo mensajeRepo;
     @Autowired
    private ChatRepo chatRepo;

    @Test //Prueba para registrar un mensaje
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:chat.sql","classpath:mensaje.sql"})
    public void registrarTest() {
        Chat chat = chatRepo.findById("3").orElse(null);
        Mensaje mensaje = new Mensaje("4","esta disponible","Miguel", LocalDateTime.now(),chat);
        Mensaje mensajeResgistrado = mensajeRepo.save(mensaje);
        Assertions.assertNotNull(mensajeResgistrado);
    }
    @Test// Prueba para eliminar un mensaje por código
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:chat.sql","classpath:mensaje.sql"})
    public void eliminarTest() {

        mensajeRepo.deleteById("3");
         Mensaje mensajeRegistrado= mensajeRepo.findById("3").orElse(null);

        Assertions.assertNull(mensajeRegistrado);
    }
    @Test// Prueba actualización de un mensaje
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:chat.sql","classpath:mensaje.sql"})
    public void actualizarTest() {
        Mensaje mensajeRegistrado = mensajeRepo.findById("2").orElse(null);
        mensajeRegistrado.setEmisor("Diego");
        mensajeRepo.save(mensajeRegistrado);
        Mensaje mensajeBuscado = mensajeRepo.findById("2").orElse(null);
        Assertions.assertEquals("Diego", mensajeBuscado.getEmisor());

    }
    @Test // SE listan  los mensajes
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:chat.sql","classpath:mensaje.sql"})
    public void ListarTest() {
        List<Mensaje> mensajes =mensajeRepo.findAll();
        mensajes.forEach(Mensaje -> System.out.println(Mensaje));
    }

}
