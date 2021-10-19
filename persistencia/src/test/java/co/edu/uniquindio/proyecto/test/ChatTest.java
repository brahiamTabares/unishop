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

    //  permite probar que se registre el chat
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:chat.sql"})
    public void registrarTest() {
        Usuario usuario= usuarioRepo.findById("000020").orElse(null);
        Chat chat = new Chat("123",usuario );
        Chat chatRegistrada = chatRepo.save(chat);
        Assertions.assertNotNull(chatRegistrada);
    }

    // prueba para eliminar un chat
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:chat.sql"})
    public void eliminarTest() {
        //borra el chat  buscando por codigo
        chatRepo.deleteById("3");
        //Se busca el chat para validar que si lo borro

        Chat chatregistrado = chatRepo.findById("3").orElse(null);
        // para decir que lo que espero es un null
        Assertions.assertNull(chatregistrado);
    }

    @Test // permite actualizar el chat
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:chat.sql"})
    public void actualizarTest() {

        Usuario usuario= usuarioRepo.findById("00002").orElse(null);
        Chat chatRegistrada = chatRepo.findById("1").orElse(null);

        chatRegistrada.setUsuario(usuario);
        //Se guarda la modificación
        chatRepo.save(chatRegistrada);

        //busca la categria
        Chat chatBuscado =  chatRepo.findById("1").orElse(null);

        // Se busca el cambio
        Assertions.assertEquals(usuario, chatBuscado.getUsuario());

    }


    @Test // programa de tipo test  que permite listar los chats
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:chat.sql"})
    public void ListarTest() {
        List<Chat> chats = chatRepo.findAll();
        chats.forEach(Chat -> System.out.println(Chat));


    }

}
