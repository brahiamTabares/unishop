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

    @Test //Prueba para registrar el detalle de la compra
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:compra.sql"})
    public void registrarTest() {
        Compra compra = compraRepo.findById("004").orElse(null);
        Producto producto= productoRepo.findById("1238").orElse(null);
        DetalleCompra detalleCompra = new DetalleCompra("3",15,50000,compra,producto);
        DetalleCompra detalleCompraResgistrada = detalleCompraRepo.save(detalleCompra);
        Assertions.assertNotNull(detalleCompraResgistrada);
    }
    @Test// Prueba para eliminar el detalle de una compra
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:telefono.sql","classpath:producto.sql","classpath:compra.sql","classpath:detalleCompra.sql"})
    public void eliminarTest() {
        detalleCompraRepo.deleteById("5");
        DetalleCompra  detalleCompraRegistrada = detalleCompraRepo.findById("5").orElse(null);
        Assertions.assertNull(detalleCompraRegistrada);
    }

    @Test // Prueba de actualización de detalle de la compra
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:telefono.sql","classpath:producto.sql","classpath:compra.sql","classpath:detalleCompra.sql"})
    public void actualizarTest() {
        DetalleCompra detalleCompraRegistrada = detalleCompraRepo.findById("4").orElse(null);
        detalleCompraRegistrada.setUnidades(3);
        detalleCompraRepo.save(detalleCompraRegistrada);
        DetalleCompra detalleCompraBuscada = detalleCompraRepo.findById("4").orElse(null);
        Assertions.assertEquals(3, detalleCompraBuscada.getUnidades());

    }

    @Test // Se listan los detalles de la compra
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:telefono.sql","classpath:producto.sql","classpath:compra.sql","classpath:detalleCompra.sql"})
    public void ListarTest() {
        List<DetalleCompra> detalleCompras =detalleCompraRepo.findAll();
        detalleCompras.forEach(DetalleCompra -> System.out.println(DetalleCompra));
    }
}




