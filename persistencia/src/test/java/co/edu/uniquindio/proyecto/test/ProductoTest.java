package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {

    @Autowired
     private ProductoRepo productoRepo;
    @Autowired
     private UsuarioRepo usuarioRepo;
    @Autowired
    private CiudadRepo ciudadRepo;

    // permite registrar un producto
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:producto.sql"})
    public void registrarTest() {

        Ciudad ciudad = ciudadRepo.findById("1").orElse(null);
        Usuario usuario = usuarioRepo.findById("00006").orElse(null);
        List<String> imagenes= new ArrayList<>();
        imagenes.add("ruta/img4.jpg");
        Producto producto= new Producto("1451","televisor",5,"pantalla plana 50 pulgadas",500462, LocalDate.now(),
                4000,ciudad,usuario,imagenes);

        Producto productoRegistrado= productoRepo.save(producto);
        Assertions.assertNotNull(productoRegistrado);
    }

    @Test// permite probar que se elimina un producto
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:producto.sql"})
    public void eliminarTest() {

        //elimina el producto buscado por el codigo
        productoRepo.deleteById("1236");
        //verifica que el producto halla sido eliminado

        Producto productoRegistrado = productoRepo.findById("1236").orElse(null);
        // se espera que la respuesta sea null
        Assertions.assertNull(productoRegistrado);
    }
    // verifica que el producto se actulize
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:producto.sql"})
    public void actualizarTest() {
        Producto productoRegistrado = productoRepo.findById("1238").orElse(null);
        productoRegistrado.setNombre("televisorHD");
        //Se guardan los cambios
        productoRepo.save(productoRegistrado);

        //busca al producto
        Producto productoBuscado = productoRepo.findById("1238").orElse(null);

        // se validan los cambios
        Assertions.assertEquals("televisorHD", productoBuscado.getNombre());

      }
      // permite hacer la prueba de que  se listan los productos
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:producto.sql"})
    public void ListarTest() {
        List<Producto> productos = productoRepo.findAll();
        productos.forEach(Producto -> System.out.println(Producto));
    }
    }


