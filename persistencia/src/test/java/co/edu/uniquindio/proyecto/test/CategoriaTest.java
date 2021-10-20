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

        // programa  de prueba de registrar  la categoria
        @Test
        @Sql("classpath:categoria.sql")
        public void registrarTest() {
            Categoria categoria = new Categoria("123", "Miguel");
            Categoria categoriaRegistrada = categoriaRepo.save(categoria);
            Assertions.assertNotNull(categoriaRegistrada);
        }

        // programa de prueba para eliminar una categoria listo
        @Test
        @Sql("classpath:categoria.sql")
        public void eliminarTest() {
            //borra la categoria buscanda por  el codigo
            categoriaRepo.deleteById("100");
            //Se busca la categoria para verificar si se borro

            Categoria categoriaRegistrada = categoriaRepo.findById("100").orElse(null);
            // para decir que lo que espero es un null
            Assertions.assertNull(categoriaRegistrada);
        }

        @Test // programa de prueba  para actualizar  la categoria
        @Sql("classpath:categoria.sql")
        public void actualizarTest() {
            Categoria categoriaRegistrada = categoriaRepo.findById("101").orElse(null);
            categoriaRegistrada.setNombre("Jaime");
            //Se guarda la modificación
            categoriaRepo.save(categoriaRegistrada);

            //busca la categria
            Categoria categoriaBuscada =  categoriaRepo.findById("101").orElse(null);

            // Se busca el cambio
            Assertions.assertEquals("Jaime", categoriaBuscada.getNombre());

        }


        @Test //  nos permite evidenciar que se listen las categorias
        @Sql({"classpath:persona.sql","classpath:administrador.sql"})
        public void ListarTest() {
            List<Categoria> categorias = categoriaRepo.findAll();
            categorias.forEach(Categoria -> System.out.println(Categoria));


        }
    }


