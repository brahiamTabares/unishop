package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Envio;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.EnvioRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.time.LocalDateTime;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EnvioTest {
     @Autowired
     private EnvioRepo envioRepo;
     @Autowired
     private CompraRepo compraRepo;


     @Test // Prueba para registrar un Envio
     @Sql({"classpath:conglomeado.sql"})
     public void registrarTest() {


          Compra compra= compraRepo.findById("002").orElse(null);

          Envio envio = new Envio("1235", LocalDateTime.now(),"Envia","Bogota carr15 local 3",
                  "Armenia Barrio La fachada mz 21 #2",compra);



     }





}
