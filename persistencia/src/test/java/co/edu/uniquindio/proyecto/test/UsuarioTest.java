package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private CiudadRepo  ciudadRepo;
    //  Permite que se registre un usuario
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql"})
    public void registrarTest() {
        Ciudad ciudad = ciudadRepo.findById("1").orElse(null);
        List<String> telefonos= new ArrayList<>();
        telefonos.add("2222222");
        Usuario  usuario = new Usuario("123","Brahiam","bdtabaresv@uqvirtual.edu","1245",ciudad,telefonos);
        Usuario usuarioResgistrado = usuarioRepo.save(usuario);
        Assertions.assertNotNull(usuarioResgistrado);
    }
    // permite  eliminar un usuario
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql"})
    public void eliminarTest() {
        //elimina el usuario  buscado por el codigo
        usuarioRepo.deleteById("00002");
        //verifica que el usuario halla sido eliminado

        Usuario usuarioRegistrado = usuarioRepo.findById("00002").orElse(null);
        // se espera que la respuesta sea null
        Assertions.assertNull(usuarioRegistrado);
    }

    @Test // este programa permite probar que el usuario se actualize
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql"})
    public void actualizarTest() {
        Usuario usuarioRegistrado = usuarioRepo.findById("00003").orElse(null);
        usuarioRegistrado.setNombre("Jose");
        //Se guardan los cambios
        usuarioRepo.save(usuarioRegistrado);

        //busca al usuario
         Usuario usuarioBuscado = usuarioRepo.findById("00003").orElse(null);

        // se validan los cambios
        Assertions.assertEquals("Jose", usuarioBuscado.getNombre());

    }
    @Test // permite listar los usuarios
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql"})
    public void ListarTest() {
        List<Usuario> usuarios = usuarioRepo.findAll();
        usuarios.forEach(Usuario -> System.out.println(Usuario));
    }




}
