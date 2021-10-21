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
     // permite probar que se esta registrando el mensaje
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:chat.sql","classpath:mensaje.sql"})
    public void registrarTest() {
        Chat chat = chatRepo.findById("3").orElse(null);
        Mensaje mensaje = new Mensaje("4","esta disponible","Miguel", LocalDateTime.now(),chat);
        Mensaje mensajeResgistrado = mensajeRepo.save(mensaje);
        Assertions.assertNotNull(mensajeResgistrado);
    }
    @Test// permite probar que se elimina el mensaje
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:chat.sql","classpath:mensaje.sql"})
    public void eliminarTest() {

        //elimina el  mensaje  buscado pro el  por el codigo
        mensajeRepo.deleteById("3");
        //verifica que el mensaje  halla sido eliminado

         Mensaje mensajeRegistrado= mensajeRepo.findById("3").orElse(null);
        // se espera que el mensaje  sea null
        Assertions.assertNull(mensajeRegistrado);
    }
    @Test// permite probar que se actualiza el mensaje
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:chat.sql","classpath:mensaje.sql"})
    public void actualizarTest() {
        Mensaje mensajeRegistrado = mensajeRepo.findById("2").orElse(null);
        mensajeRegistrado.setEmisor("Diego");
        //Se guardan los cambios
        mensajeRepo.save(mensajeRegistrado);

        //busca el  mensaje actualizado
        Mensaje mensajeBuscado = mensajeRepo.findById("2").orElse(null);

        // se validan los cambios
        Assertions.assertEquals("Diego", mensajeBuscado.getEmisor());

    }
    @Test// permite listar  los mensajes
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:chat.sql","classpath:mensaje.sql"})
    public void ListarTest() {
        List<Mensaje> mensajes =mensajeRepo.findAll();
        mensajes.forEach(Mensaje -> System.out.println(Mensaje));
    }

}
