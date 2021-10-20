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

    // programa  de prueba de registrar  una ciudad
    @Test
    @Sql({"classpath:ciudad.sql"})
    public void registrarTest() {

        Ciudad ciudad = new Ciudad("6","Barranquilla");
        Ciudad ciudadResgistrada = ciudadRepo.save(ciudad);
        Assertions.assertNotNull(ciudadResgistrada);
    }

    // programa de prueba para eliminar una ciudad
    @Test
    @Sql({"classpath:ciudad.sql"})
    public void eliminarTest() {
        //borra  la ciudad buscanda por codigo
        ciudadRepo.deleteById("2");
        //Se  busca la ciudad para verificar que  si la borro

        Ciudad ciudadRegistrada = ciudadRepo.findById("2").orElse(null);
        // para decir que lo que espero es un null
        Assertions.assertNull(ciudadRegistrada);
    }

    @Test // programa de prueba  para actualizar una ciudad
    @Sql({"classpath:ciudad.sql"})
    public void actualizarTest() {
        Ciudad ciudadRegistrada = ciudadRepo.findById("4").orElse(null);
        ciudadRegistrada.setNombre("Pasto");
        //Se guarda la modificación
        ciudadRepo.save(ciudadRegistrada);

        //busca la ciudad
        Ciudad ciudadBuscado = ciudadRepo.findById("4").orElse(null);

        // Se busca el cambio
        Assertions.assertEquals("Pasto", ciudadBuscado.getNombre());

    }


    @Test // programa de tipo test para listar las ciudades creadas
    @Sql({"classpath:ciudad.sql"})
    public void ListarTest() {
        List<Ciudad> ciudades = ciudadRepo.findAll();
        ciudades.forEach(Ciudad -> System.out.println(Ciudad));


    }
}
