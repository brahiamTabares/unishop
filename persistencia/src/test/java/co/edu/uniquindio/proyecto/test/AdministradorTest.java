package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.repositorios.AdministradorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTest {

    @Autowired
    private AdministradorRepo administradorRepo;

    // Prueba para registrar al administrador
    @Test
    @Sql({"classpath:persona.sql","classpath:administrador.sql"})
    public void registrarTest() {
        Administrador administrador = new Administrador("123", "Miguel", "Miguela@gmail.com", "1342");
        Administrador administradorResgistrado = administradorRepo.save(administrador);
        Assertions.assertNotNull(administradorResgistrado);
    }

    // Prueba para eliminar un administrador
    @Test
    @Sql({"classpath:persona.sql","classpath:administrador.sql"})
    public void eliminarTest() {
        // Eliminar el administrador por código
        administradorRepo.deleteById("00001");

        Administrador administradorRegistrado = administradorRepo.findById("00001").orElse(null);

        Assertions.assertNull(administradorRegistrado);
    }

    @Test // Prueba  para actualizar un administrador
    @Sql({"classpath:persona.sql","classpath:administrador.sql"})
    public void actualizarTest() {
        Administrador administradorRegistrado = administradorRepo.findById("00004").orElse(null);
        administradorRegistrado.setNombre("Daniel");

        administradorRepo.save(administradorRegistrado);//Guarda la modificación

        Administrador administradorBuscado = administradorRepo.findById("00004").orElse(null);

        Assertions.assertEquals("Daniel", administradorBuscado.getNombre());

    }

    @Test // listar administradores
    @Sql({"classpath:persona.sql","classpath:administrador.sql"})
    public void ListarTest() {
        List<Administrador> administradores = administradorRepo.findAll();
        administradores.forEach(Administrador -> System.out.println(Administrador));


    }
}
