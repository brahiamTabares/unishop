package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class TallerTest {
    @Autowired
    private ProductoRepo productoRepo;

    @Test // Ejercicio 1
    @Sql({"classpath:conglomerado.sql"})
    public void ejercicioTest() {

        List<Object[]> lista = productoRepo.indicarProductosEnSubastaPorCategoria();
        for (Object[] objecto:lista) {
            System.out.println(objecto[0]+ " - "+objecto[1]);

        }

    }
}
