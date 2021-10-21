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

    //  Permite que se registre una subasta
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql", "classpath:usuario.sql", "classpath:producto.sql","classpath:subasta.sql"})
    public void registrarTest() {
        Producto producto=productoRepo.findById("1238").orElse(null);
        Subasta subasta = new Subasta("40", LocalDate.now(),producto);
        Subasta subastaResgistrada = subastaRepo.save(subasta);
        Assertions.assertNotNull(subastaResgistrada);
    }
    // permite  eliminar una subasta
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql", "classpath:usuario.sql","classpath:producto.sql","classpath:subasta.sql"})
    public void eliminarTest() {
        //elimina la subasta   buscada por el codigo
        subastaRepo.deleteById("20");
        //verifica que la subasta  halla sido eliminado

        Subasta  subastaRegistrada= subastaRepo.findById("20").orElse(null);
        // se espera que la respuesta sea null
        Assertions.assertNull(subastaRegistrada);
    }

    @Test // este programa permite probar  la subasta  se actualiza
    @Sql({"classpath:ciudad.sql","classpath:persona.sql", "classpath:usuario.sql","classpath:producto.sql","classpath:subasta.sql"})
    public void actualizarTest() {
        Subasta subastaRegistrada = subastaRepo.findById("10").orElse(null);
        subastaRegistrada.setCodigo("60");
        //Se guardan los cambios
        subastaRepo.save(subastaRegistrada);

        //busca  la subasta
        Subasta  subastaBuscada = subastaRepo.findById("10").orElse(null);

        // se validan los cambios
        Assertions.assertEquals("60", subastaBuscada.getCodigo());

    }
    @Test // permite listar  las subastas
    @Sql({"classpath:ciudad.sql","classpath:persona.sql", "classpath:usuario.sql","classpath:producto.sql","classpath:subasta.sql"})
    public void ListarTest() {
        List<Subasta> subastas = subastaRepo.findAll();
        subastas.forEach(Subasta -> System.out.println(Subasta));
    }





}
