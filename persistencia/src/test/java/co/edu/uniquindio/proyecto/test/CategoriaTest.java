package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.repositorios.CategoriaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CategoriaTest {

        @Autowired
        private CategoriaRepo categoriaRepo;


        @Test // Prueba para registrar una categoria
        @Sql("classpath:categoria.sql")
        public void registrarTest() {
            Categoria categoria = new Categoria("123", "Miguel");
            Categoria categoriaRegistrada = categoriaRepo.save(categoria);
            Assertions.assertNotNull(categoriaRegistrada);
        }


        @Test // Prueba para eliminar una categoria por código
        @Sql("classpath:categoria.sql")
        public void eliminarTest() {

            categoriaRepo.deleteById("100");
            //Se valida que la categoría ya no exista
            Categoria categoriaRegistrada = categoriaRepo.findById("100").orElse(null);
            Assertions.assertNull(categoriaRegistrada);
        }

        @Test // Prueba para actualizar una categoría
        @Sql("classpath:categoria.sql")
        public void actualizarTest() {
            Categoria categoriaRegistrada = categoriaRepo.findById("101").orElse(null);
            categoriaRegistrada.setNombre("Jaime");
            categoriaRepo.save(categoriaRegistrada);
            Categoria categoriaBuscada =  categoriaRepo.findById("101").orElse(null);
            Assertions.assertEquals("Jaime", categoriaBuscada.getNombre()); // Se verifica la modificación
        }


        @Test // Se lista las categorias
        @Sql({"classpath:persona.sql","classpath:administrador.sql"})
        public void ListarTest() {
            List<Categoria> categorias = categoriaRepo.findAll();
            categorias.forEach(Categoria -> System.out.println(Categoria));

        }
    }


