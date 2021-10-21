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
    @Autowired
    UsuarioRepo usuarioRepo;


    @Test
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:compra.sql"})
    public void registrarTest() {
        Usuario usuario = usuarioRepo.findById("00006").orElse(null);
        Compra  compra= new Compra("005",LocalDateTime.now(), MedioPago.NEQUI,usuario);
        Compra compraResgistrada = compraRepo.save(compra);
        Assertions.assertNotNull(compraResgistrada);
    }

    @Test // Prueba eliminar compra por código
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:compra.sql"})
    public void eliminarTest() {
        compraRepo.deleteById("004");
        Compra compraRegistrada = compraRepo.findById("004").orElse(null); // Se valida la eliminación
        Assertions.assertNull(compraRegistrada);
    }

    @Test // Prueba de Actualización de compra
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:compra.sql"})
    public void actualizarTest() {
        Compra compraRegistrada = compraRepo.findById("005").orElse(null);
        compraRegistrada.setMedioPago(MedioPago.NEQUI);
        compraRepo.save(compraRegistrada);
        Compra compraBuscada = compraRepo.findById("005").orElse(null);
        Assertions.assertEquals(MedioPago.NEQUI, compraBuscada.getMedioPago());

    }
    @Test // Se lista las compras
    @Sql({"classpath:ciudad.sql","classpath:persona.sql","classpath:usuario.sql","classpath:compra.sql"})
    public void ListarTest() {
        List<Compra> compras = compraRepo.findAll();
        compras.forEach(Compra -> System.out.println(Compra));
    }




}
