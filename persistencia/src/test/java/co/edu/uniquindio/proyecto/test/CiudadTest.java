package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.AdministradorRepo;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {
    @Autowired
    private CiudadRepo ciudadRepo;

    @Test // Prueba para registrar una ciudad
    @Sql({"classpath:ciudad.sql"})
    public void registrarTest() {

        Ciudad ciudad = new Ciudad("6","Barranquilla");
        Ciudad ciudadResgistrada = ciudadRepo.save(ciudad);
        Assertions.assertNotNull(ciudadResgistrada);
    }

    @Test // Prueba para eliminar una ciudad por código
    @Sql({"classpath:ciudad.sql"})
    public void eliminarTest() {
        ciudadRepo.deleteById("2");
        Ciudad ciudadRegistrada = ciudadRepo.findById("2").orElse(null); // Se valida que no exista la ciudad
        Assertions.assertNull(ciudadRegistrada); // Se espera de resultado el null
    }

    @Test // Prueba para actualizar una ciudad
    @Sql({"classpath:ciudad.sql"})
    public void actualizarTest() {
        Ciudad ciudadRegistrada = ciudadRepo.findById("4").orElse(null);
        ciudadRegistrada.setNombre("Pasto");
        ciudadRepo.save(ciudadRegistrada);
        Ciudad ciudadBuscado = ciudadRepo.findById("4").orElse(null);
        Assertions.assertEquals("Pasto", ciudadBuscado.getNombre());

    }

    @Test // listar las ciudades
    @Sql({"classpath:ciudad.sql"})
    public void ListarTest() {
        List<Ciudad> ciudades = ciudadRepo.findAll();
        ciudades.forEach(Ciudad -> System.out.println(Ciudad));


    }
}
