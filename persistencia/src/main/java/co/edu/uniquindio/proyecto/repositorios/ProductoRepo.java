package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.dto.DatoDTO;
import co.edu.uniquindio.proyecto.entidades.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ProductoRepo extends JpaRepository<Producto,String> {

  //  Optional<Producto> findByCodigo(String codigo);
  //  List<Producto>findAllByProductoContains(String nombre);
  //  List<Producto>findAllByUnidadesContains(String unidades);
  //  List<Producto>findAllByDescripcionContains(String descripcion);
   // List<Producto>findAllByPrecioContains(String precio);
  //  List<Producto>findAllByFechaLimiteContains(String fechaLimite);
  @Query("select p from Producto p where p.vendedor.codigo = :codigo")
    List<Producto>findAllByVendedor(String codigo);

    //1.	La cantidad de productos que están en subasta por cada categoría.
    @Query("select c.nombre, count (p) from Categoria c join c.productos p join p.subastas s group by c")
    List<Object[]> indicarProductosEnSubastaPorCategoria();


  @Query("select new co.edu.uniquindio.proyecto.dto.DatoDTO(p.vendedor.nombre,COUNT(1) ) from Producto p group by p.vendedor")
  List<DatoDTO> numeroProductosByVendedor();

  @Query("select new co.edu.uniquindio.proyecto.dto.DatoDTO(c.nombre,c.productos.size ) from Categoria c ")
  List<DatoDTO> numeroProductosByCategoria();

  @Query("select new co.edu.uniquindio.proyecto.dto.DatoDTO(c.nombre,c.productos.size ) from Ciudad c ")
  List<DatoDTO> numeroProductosByCiudad();

  // 2.	Una lista con las categorías y su calificación promedio.
    // Ordene la lista de mayor a menor de acuerdo a la calificación promedio.
    // (incluya todos las categorías así no tenga productos con calificaciones)
    @Query("select c.nombre, AVG(cm.calificacion) from Categoria c join c.productos p join p.comentarios cm group by c.nombre order by cm.calificacion desc")
    List<Object[]> indicarCategoriasConCalificacionPromedio();
    //group by c

    @Query("select p from Usuario u join u.productosFavoritos p where u.codigo = :codigo")
    List<Producto> obtenerFavoritos(String codigo);



  // 3.	La cantidad de compras que se hace por cada medio de pago disponible.

    @Query("select c.medioPago, count(c) from Compra c group by c.medioPago")

    List<Object[]> indicarCantidadComprasMedioPago();


    // 4.	Una lista de los chats de un vendedor.

    @Query("select c from Producto p join p.vendedor v join v.chats c where p.vendedor.codigo =:codigo")
    List<Chat> indicarChatsPorVendedor(String codigo);


    // 5.	La lista de subastas de una categoría específica. Tenga en cuenta que solo debe mostrar las subastas que aún están disponibles (validar fecha).

    @Query("select s from Subasta s join s.producto p join p.categorias c where c.codigo =:codigo and current_timestamp < s.fecha")

    List<Subasta> ListarSubastasPorCategoria(String codigo);

    // 6.	Una lista de los comentarios de un producto específico que aún no tienen respuesta.

    @Query("select c from Comentario c join c.producto p where p.codigo =:codigo and c.respuesta is null")

    List<Comentario> indicarComentariosSinRespuesta(String codigo);

    // 7.	Una lista de productos que tienen un descuento que está dentro de un rango que se pase por parámetro. Solo muestre los productos que tengan unidades disponibles.

    @Query("select p from Producto p where (p.descuento between :rangoInicial and :rangoFinal) and p.unidades > 0")
    List<Producto>ListarProductosDisponiblesConDescuentoEnRango(float rangoInicial, float rangoFinal);

    // 8.	Dado el código de una subasta, devolver el usuario ganador de dicha subasta.

    @Query("select s from Subasta s join s.subastaUsuarios su where su.codigo= :codigo")
    List<Usuario> mostrarUsuarioGanador(String codigo);




  // 9.	El valor total de cada una de las compras que ha hecho un usuario específico.



    // 10.	El producto más vendido de una categoría específica.
//
//    @Query ("select max(d.unidades) from DetalleCompra d join d.producto.categorias c where c.codigo = :codCategoria")
//    List<Integer>obtenerUnidadesMaximosPorDetalleCompra(String codCategoria);
//
//    @Query("select d.producto, sum(d.unidades) from DetalleCompra d  join d.producto.categorias c where c.codigo = :codCategoria group by d.producto having sum (d.unidades)")
//    List<Producto> productoMasVendido(Integer codCategoria);


}
