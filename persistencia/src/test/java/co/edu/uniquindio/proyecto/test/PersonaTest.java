package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.PersonaRepo;
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
public class PersonaTest {
     @Autowired
    private PersonaRepo personaRepo;


    @Test //  Prueba para registrar una persona
    @Sql("classpath:persona.sql")
    public void registrarTest() {
        Persona persona = new Persona("00008","Alvaro","bdtabaresv@uqvirtual.edu","15475","alvarin");
        Persona personaResgistrada = personaRepo.save(persona);
        Assertions.assertNotNull(personaResgistrada);
    }

    @Test// Prueba para eliminar una persona por el código
    @Sql("classpath:persona.sql")
    public void eliminarTest() {
        personaRepo.deleteById("00004");
        Persona personaRegistrada = personaRepo.findById("00004").orElse(null);
        Assertions.assertNull(personaRegistrada);
    }

    @Test // Prueba actualización de una persona
    @Sql("classpath:persona.sql")
    public void actualizarTest() {
        Persona personaRegistrada = personaRepo.findById("00003").orElse(null);
        personaRegistrada.setNombre("Javier");
        personaRepo.save(personaRegistrada);
        Persona  personaBuscada = personaRepo.findById("00003").orElse(null);
        Assertions.assertEquals("Javier", personaBuscada.getNombre());

    }
    @Test // permite listar las personas
    @Sql("classpath:persona.sql")
    public void ListarTest() {
        List<Persona> personas = personaRepo.findAll();
        personas.forEach(Persona-> System.out.println(Persona));
    }

}
