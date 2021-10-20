package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DetalleCompraTest {

    @Autowired
    private DetalleCompraRepo detalleCompraRepo;
    @Autowired
    private CompraRepo compraRepo;
    @Autowired
    private ProductoRepo productoRepo;
    //Permite probar que se registre el detalle de la compra
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:compra.sql"})
    public void registrarTest() {
        Compra compra = compraRepo.findById("004").orElse(null);
        Producto producto= productoRepo.findById("1238").orElse(null);
        DetalleCompra detalleCompra = new DetalleCompra("3",15,50000,compra,producto);
        DetalleCompra detalleCompraResgistrada = detalleCompraRepo.save(detalleCompra);
        Assertions.assertNotNull(detalleCompraResgistrada);
    }
    @Test// permite probar que se elimina el detalle de una compra
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:telefono.sql","classpath:producto.sql","classpath:compra.sql","classpath:detalleCompra.sql"})
    public void eliminarTest() {

        //elimina el detalle de la compra buscada por el codigo
         detalleCompraRepo.deleteById("5");
        //verifica que el detalle de la compra  halla sido eliminado

        DetalleCompra  detalleCompraRegistrada = detalleCompraRepo.findById("5").orElse(null);
        // se espera que la respuesta sea null
        Assertions.assertNull(detalleCompraRegistrada);
    }
    // verifica que el detalle de la compra  se actulize
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:telefono.sql","classpath:producto.sql","classpath:compra.sql","classpath:detalleCompra.sql"})
    public void actualizarTest() {
        DetalleCompra detalleCompraRegistrada = detalleCompraRepo.findById("4").orElse(null);
        detalleCompraRegistrada.setUnidades(3);
        //Se guardan los cambios
        detalleCompraRepo.save(detalleCompraRegistrada);

        //busca el detalle de la compra
        DetalleCompra detalleCompraBuscada = detalleCompraRepo.findById("4").orElse(null);

        // se validan los cambios
        Assertions.assertEquals(3, detalleCompraBuscada.getUnidades());

    }

    // permite hacer la prueba de que  se listan los detalles de la compra
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:telefono.sql","classpath:producto.sql","classpath:compra.sql","classpath:detalleCompra.sql"})
    public void ListarTest() {
        List<DetalleCompra> detalleCompras =detalleCompraRepo.findAll();
        detalleCompras.forEach(DetalleCompra -> System.out.println(DetalleCompra));
    }
}




