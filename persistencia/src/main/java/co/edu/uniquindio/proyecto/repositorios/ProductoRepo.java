package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,String> {
    @Query("select c.nombre, count (p) from Categoria c join c.productos p join p.subastas s group by c")
    List<Object[]> indicarProductosEnSubastaPorCategoria();

    @Query ("")

}
