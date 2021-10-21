package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComentarioTest {

    @Autowired
    private ComentarioRepo comentarioRepo;
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private ProductoRepo productoRepo;


    @Test // Prueba para registrar un comentario
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:producto.sql","classpath:comentario.sql"})
    public void registrarTest() {

        Producto producto = productoRepo.findById("2468").orElse(null);
        Usuario usuario = usuarioRepo.findById("00005").orElse(null);
        Comentario comentario = new Comentario("6", "Quisiera pedir la garantia de mi producto ", "porfavor envie una solicitud", LocalDateTime.now()
                , 10, usuario, producto);
        Comentario comentarioRegistrado = comentarioRepo.save(comentario);
        Assertions.assertNotNull(comentarioRegistrado);

    }

        @Test // Prueba para eliminar un comentario por código
        @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:producto.sql","classpath:comentario.sql"})
        public void eliminarRegistro(){
            comentarioRepo.deleteById("4");
            Comentario comentarioRegistrado = comentarioRepo.findById("4").orElse(null);
            Assertions.assertNull(comentarioRegistrado);
        }

    @Test // Prueba de actualización de un comentario
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:producto.sql","classpath:comentario.sql"})
    public void actualizarTest() {
        Comentario comentarioRegistrado = comentarioRepo.findById("2").orElse(null);
        comentarioRegistrado.setCalificacion(10);
        comentarioRepo.save(comentarioRegistrado);
        Comentario coementarioBuscado =comentarioRepo.findById("2").orElse(null);
        Assertions.assertEquals(10, coementarioBuscado.getCalificacion());

    }

    @Test // Se listan los comentarios
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:producto.sql","classpath:comentario.sql"})
    public void ListarTest() {
        List<Comentario> comentarios = comentarioRepo.findAll();
        comentarios.forEach(Comentario -> System.out.println(Comentario));
    }
    }



