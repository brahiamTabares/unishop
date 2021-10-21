package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Chat;
import co.edu.uniquindio.proyecto.entidades.Subasta;
import co.edu.uniquindio.proyecto.entidades.SubastaUsuario;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.SubastaRepo;
import co.edu.uniquindio.proyecto.repositorios.SubastaUsuarioRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SubastaUsuarioTest {

    @Autowired
     private SubastaUsuarioRepo subastaUsuarioRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private SubastaRepo subastaRepo;


    //  permite probar que se registre la subastaUsuario
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:telefono.sql","classpath:producto.sql","classpath:subasta.sql","classpath:subastaUsuario.sql"})
    public void registrarTest() {
        Usuario usuario= usuarioRepo.findById("00006").orElse(null);
        Subasta subasta= subastaRepo.findById("30").orElse(null);
        SubastaUsuario subastaUsuario= new SubastaUsuario("4",30000, LocalDate.now(),subasta,usuario);
        SubastaUsuario subastaUsuarioRegistrada= subastaUsuarioRepo.save(subastaUsuario);
        Assertions.assertNotNull(subastaUsuarioRegistrada);
    }
    // prueba que se elimine la subastaUsuario
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:telefono.sql","classpath:producto.sql","classpath:subasta.sql","classpath:subastaUsuario.sql"})
    public void eliminarTest() {
        //borra la subastaUsuario buscanda por codigo
         subastaUsuarioRepo.deleteById("2");
        //Se busca el chat para validar que si lo borro

        SubastaUsuario  subastaUsuarioRegistrada = subastaUsuarioRepo.findById("2").orElse(null);
        // para decir que lo que espero es un null
        Assertions.assertNull(subastaUsuarioRegistrada);
    }
    // prueba  para verificar que actualize  la subastaUsuario
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:telefono.sql","classpath:producto.sql","classpath:subasta.sql","classpath:subastaUsuario.sql"})
    public void actualizarTest() {

        SubastaUsuario  subastaUsuario= subastaUsuarioRepo.findById("1").orElse(null);
        SubastaUsuario subastaUsuaioRegistrada = subastaUsuarioRepo.findById("1").orElse(null);

        subastaUsuaioRegistrada.setValor(50000);
        //Se guarda la modificación
        subastaUsuarioRepo.save(subastaUsuaioRegistrada);

        //busca la subastaUsuario
        SubastaUsuario subastaUsuarioBuscada =  subastaUsuarioRepo.findById("1").orElse(null);

        // Se busca el cambio
        Assertions.assertEquals(50000, subastaUsuarioBuscada.getValor());

    }
    // Prueba que se puedan listar las subastaUsuario
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:telefono.sql","classpath:producto.sql","classpath:subasta.sql","classpath:subastaUsuario.sql"})
    public void ListarTest() {
        List<SubastaUsuario> subastaUsuarios = subastaUsuarioRepo.findAll();
        subastaUsuarios.forEach(SubastaUsuario -> System.out.println(SubastaUsuario));


    }





}
