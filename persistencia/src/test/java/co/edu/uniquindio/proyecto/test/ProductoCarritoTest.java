package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.repositorios.ProductoCarritoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoCarritoTest {
    @Autowired
    ProductoCarritoRepo productoCarritoRepo;

}
