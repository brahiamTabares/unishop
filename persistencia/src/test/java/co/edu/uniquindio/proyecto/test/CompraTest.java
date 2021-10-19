package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.MedioPago;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompraTest {

    @Autowired
    private CompraRepo compraRepo;
    @Autowired UsuarioRepo usuarioRepo;




    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:compra.sql"})
    public void registrarTest() {
        Usuario usuario = usuarioRepo.findById("00006").orElse(null);
        Compra  compra= new Compra("005",LocalDateTime.now(), MedioPago.NEQUI,usuario);
        Compra compraResgistrada = compraRepo.save(compra);
        Assertions.assertNotNull(compraResgistrada);
    }
    // permite  eliminar compra
    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:compra.sql"})
    public void eliminarTest() {
        //elimina  la compra  buscada por el codigo
        compraRepo.deleteById("004");
        //verifica que la compra halla sido eliminada

        Compra compraRegistrada = compraRepo.findById("004").orElse(null);
        // se espera que la respuesta sea null
        Assertions.assertNull(compraRegistrada);
    }

    @Test // este programa permite probar que la compra  se actualize
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:compra.sql"})
    public void actualizarTest() {
        Compra compraRegistrada = compraRepo.findById("005").orElse(null);
        compraRegistrada.setMedioPago(MedioPago.NEQUI);
        //Se guardan los cambios
        compraRepo.save(compraRegistrada);

        //busca la compra
        Compra compraBuscada = compraRepo.findById("005").orElse(null);

        // se validan los cambios
        Assertions.assertEquals(MedioPago.NEQUI, compraBuscada.getMedioPago());

    }
    @Test // permite listar las compras
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:compra.sql"})
    public void ListarTest() {
        List<Compra> compras = compraRepo.findAll();
        compras.forEach(Compra -> System.out.println(Compra));
    }




}
