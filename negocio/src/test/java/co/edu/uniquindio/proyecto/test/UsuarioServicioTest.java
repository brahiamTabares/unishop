package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class UsuarioServicioTest {
       @Autowired
      private UsuarioServicio usuarioServicio;
    @Autowired
    private CiudadRepo ciudadRepo;


    @Test

       public void registrarTest(){

           List<String> telefonos = new ArrayList<>();
           telefonos.add("2222222");
           Usuario u =new Usuario("123","Sandra","quinteroS@gmail.com","3654","PEPE",null,telefonos);
        try {
            Usuario respuesta= usuarioServicio.registrar(u);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.assertTrue(false);
        }
    }
      @Test
    public  void eliminarTest(){

          try {
              usuarioServicio.eliminar("00002");
              Assertions.assertTrue(true);
          } catch (Exception e) {
              e.printStackTrace();
              Assertions.assertTrue(false);
          }


      }

}
