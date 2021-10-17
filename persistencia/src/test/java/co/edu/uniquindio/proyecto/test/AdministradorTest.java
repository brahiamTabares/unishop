package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.repositorios.AdministradorRepo;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTest {
    private AdministradorRepo administradorRepo;
}
