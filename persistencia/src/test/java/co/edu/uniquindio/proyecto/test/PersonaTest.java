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

    //  Permite que se registre  una persona
    @Test
    @Sql("classpath:persona.sql")
    public void registrarTest() {
        Persona persona = new Persona("00008","Alvaro","bdtabaresv@uqvirtual.edu","15475");
        Persona personaResgistrada = personaRepo.save(persona);
        Assertions.assertNotNull(personaResgistrada);
    }
    // permite   probar que se elimino una persona
    @Test
    @Sql("classpath:persona.sql")
    public void eliminarTest() {
        //elimina  la persona buscada por el codigo
        personaRepo.deleteById("00004");
        //verifica que  la persona  halla sido eliminada

        Persona personaRegistrada = personaRepo.findById("00004").orElse(null);
        // se espera que la respuesta sea null
        Assertions.assertNull(personaRegistrada);
    }

    @Test // este programa permite probar que la persona  se actualize
    @Sql("classpath:persona.sql")
    public void actualizarTest() {
        Persona personaRegistrada = personaRepo.findById("00003").orElse(null);
        personaRegistrada.setNombre("Javier");
        //Se guardan los cambios
        personaRepo.save(personaRegistrada);

        //busca la persona
        Persona  personaBuscada = personaRepo.findById("00003").orElse(null);

        // se validan los cambios
        Assertions.assertEquals("Javier", personaBuscada.getNombre());

    }
    @Test // permite listar las personas
    @Sql("classpath:persona.sql")
    public void ListarTest() {
        List<Persona> personas = personaRepo.findAll();
        personas.forEach(Persona-> System.out.println(Persona));
    }

}
