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


    @Test // Prueba para registrar un producto
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

    @Test // Prueba para eliminar un producto por código
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:producto.sql"})
    public void eliminarTest() {

        productoRepo.deleteById("1236");
        Producto productoRegistrado = productoRepo.findById("1236").orElse(null);
        Assertions.assertNull(productoRegistrado);
    }

    @Test // Prueba de actualización de un producto
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:producto.sql"})
    public void actualizarTest() {
        Producto productoRegistrado = productoRepo.findById("1238").orElse(null);
        productoRegistrado.setNombre("televisorHD");
        productoRepo.save(productoRegistrado);
        Producto productoBuscado = productoRepo.findById("1238").orElse(null);
        Assertions.assertEquals("televisorHD", productoBuscado.getNombre());
      }

    @Test // Prueba para listar los productos
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:producto.sql"})
    public void ListarTest() {
        List<Producto> productos = productoRepo.findAll();
        productos.forEach(Producto -> System.out.println(Producto));
    }
    }


