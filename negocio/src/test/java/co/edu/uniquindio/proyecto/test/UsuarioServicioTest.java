package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.junit.Test;
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
         Ciudad ciudad = ciudadRepo.findById("2").orElse(null);
           List<String> telefonos = new ArrayList<>();
           telefonos.add("2222222");
           Usuario u =new Usuario("123","Sandra","quinteroS@gmail.com","3654","PEPE",ciudad,telefonos);
        try {
            usuarioServicio.registrarUsuario(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
