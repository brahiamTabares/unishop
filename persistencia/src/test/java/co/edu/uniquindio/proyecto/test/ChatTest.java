package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Chat;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CategoriaRepo;
import co.edu.uniquindio.proyecto.repositorios.ChatRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ChatTest {

    @Autowired
    private ChatRepo chatRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;


    @Test //  Prueba de un registro en el chat
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:chat.sql"})
    public void registrarTest() {
        Usuario usuario= usuarioRepo.findById("000020").orElse(null);
        Chat chat = new Chat("123",usuario );
        Chat chatRegistrada = chatRepo.save(chat);
        Assertions.assertNotNull(chatRegistrada);
    }

    @Test // prueba para eliminar un chat por código
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:chat.sql"})
    public void eliminarTest() {
        chatRepo.deleteById("3");
        //Se valida que no exista el chat
        Chat chatregistrado = chatRepo.findById("3").orElse(null);
        Assertions.assertNull(chatregistrado);
    }

    @Test // Prueba para actualizar el chat
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:chat.sql"})
    public void actualizarTest() {

        Usuario usuario= usuarioRepo.findById("00002").orElse(null);
        Chat chatRegistrada = chatRepo.findById("1").orElse(null);
        chatRegistrada.setUsuario(usuario);
        chatRepo.save(chatRegistrada);
        Chat chatBuscado =  chatRepo.findById("1").orElse(null);
        Assertions.assertEquals(usuario, chatBuscado.getUsuario());
    }

    @Test // Se listan los chats
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:chat.sql"})
    public void ListarTest() {
        List<Chat> chats = chatRepo.findAll();
        chats.forEach(Chat -> System.out.println(Chat));
    }

}
