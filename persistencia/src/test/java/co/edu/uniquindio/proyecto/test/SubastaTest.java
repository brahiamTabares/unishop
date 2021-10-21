package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Subasta;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.SubastaRepo;
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
public class SubastaTest {

    @Autowired
    private SubastaRepo subastaRepo;
    @Autowired
    private  ProductoRepo productoRepo;


    @Test //  Prueba para registrar una subasta
    @Sql({"classpath:ciudad.sql","classpath:persona.sql", "classpath:usuario.sql", "classpath:producto.sql","classpath:subasta.sql"})
    public void registrarTest() {
        Producto producto=productoRepo.findById("1238").orElse(null);
        Subasta subasta = new Subasta("40", LocalDate.now(),producto);
        Subasta subastaResgistrada = subastaRepo.save(subasta);
        Assertions.assertNotNull(subastaResgistrada);
    }

    @Test // Prueba para eliminar una subasta por código
    @Sql({"classpath:ciudad.sql","classpath:persona.sql", "classpath:usuario.sql","classpath:producto.sql","classpath:subasta.sql"})
    public void eliminarTest() {
        subastaRepo.deleteById("20");
        Subasta  subastaRegistrada= subastaRepo.findById("20").orElse(null);
        Assertions.assertNull(subastaRegistrada);
    }

    @Test // Prueba de actualización de subasta
    @Sql({"classpath:ciudad.sql","classpath:persona.sql", "classpath:usuario.sql","classpath:producto.sql","classpath:subasta.sql"})
    public void actualizarTest() {
        Subasta subastaRegistrada = subastaRepo.findById("10").orElse(null);
        subastaRegistrada.setCodigo("60");
        subastaRepo.save(subastaRegistrada);
        Subasta  subastaBuscada = subastaRepo.findById("10").orElse(null);
        Assertions.assertEquals("60", subastaBuscada.getCodigo());

    }
    @Test // listar  las subastas
    @Sql({"classpath:ciudad.sql","classpath:persona.sql", "classpath:usuario.sql","classpath:producto.sql","classpath:subasta.sql"})
    public void ListarTest() {
        List<Subasta> subastas = subastaRepo.findAll();
        subastas.forEach(Subasta -> System.out.println(Subasta));
    }





}
