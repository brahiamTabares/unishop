package co.edu.uniquindio.proyecto.controllers;

import co.edu.uniquindio.proyecto.controllers.util.Mensaje;
import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.DatoDTO;
import co.edu.uniquindio.proyecto.dto.DescuentoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.ComentarioServicio;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.ReporteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/productos")
public class ProductoController {
    private ProductoServicio productoServicio;
    private ComentarioServicio comentarioServicio;
    private ReporteServicio reporteServicio;



    @Autowired
    public ProductoController(ProductoServicio productoServicio,ComentarioServicio comentarioServicio,ReporteServicio reporteServicio) {
        this.productoServicio = productoServicio;
        this.comentarioServicio = comentarioServicio;
        this.reporteServicio=reporteServicio;
    }

    @GetMapping
    public List<ProductoDTO> listarProductos(@RequestParam(required = false) String codigoCategoria,
                                             @RequestParam(required = false) Float precioMinimo,
                                             @RequestParam(required = false) Float precioMaximo,
                                             @RequestParam(required = false) String codigoCiudad,
                                             @RequestParam(required = false) String codigoVendedor) {
        return productoServicio.listar()
                .stream()
                .filter(p->filtrarProducto(p,codigoCategoria,precioMinimo,precioMaximo,codigoCiudad,codigoVendedor))
                .map(ProductoDTO::of)
                .collect(Collectors.toList());
    }


    @GetMapping("/reportes/byCiudad")
    public List<DatoDTO> generarReporteProductosByCiudad() {
        return reporteServicio.generarReporteProductosPorCiudad();
    }

    @GetMapping("/reportes/byCategoria")
    public List<DatoDTO> generarReporteProductosByCategoria() {
        return reporteServicio.generarReporteProductosPorCategoria();
    }

    private boolean filtrarProducto(Producto producto, String codigoCategoria,
                                    Float precioMinimo, Float precioMaximo,
                                    String codigoCiudad, String codigoVendedor){
        if( precioMaximo != null && producto.getPrecio() > precioMaximo ){
            return false;
        }
        if( precioMinimo != null && producto.getPrecio() < precioMinimo ){
            return false;
        }
        if( codigoCategoria != null && producto.getCategorias().stream().filter( c->c.getCodigo().equals(codigoCategoria) ).count() == 0 ){
            return false;
        }
        if( codigoCiudad != null && !producto.getCiudad().getCodigo().equals(codigoCiudad) ){
            return false;
        }
        if( codigoVendedor != null && !producto.getVendedor().getCodigo().equals(codigoVendedor) ){
            return false;
        }
        return true;
    }
    // end::get-aggregate-root[]

    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto)  {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body( ProductoDTO.of(productoServicio.registrar(producto)) );
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new Mensaje(e.getMessage()));
        }
    }
    @PostMapping("/{codigo}/comentarios")
    public ResponseEntity<?> adicionarComentario(@PathVariable String codigo,@RequestBody Comentario comentario)  {
        try{
            Producto producto = productoServicio.obtener(codigo);
            comentario.setProducto(producto);
            comentario.setFechaComentario( LocalDateTime.now() );
            return ResponseEntity.status(HttpStatus.CREATED).body( ComentarioDTO.of(comentarioServicio.registrar(comentario)) );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new Mensaje(e.getMessage()));
        }
    }

    // Single item

    @GetMapping("/{codigo}")
    public ResponseEntity<?> obtenerProducto(@PathVariable String codigo)  {
        try{
            return ResponseEntity.ok( ProductoDTO.of(productoServicio.obtener(codigo)) );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje(e.getMessage()));
        }
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable String codigo) {
        try{
            producto.setCodigo(codigo);
            return ResponseEntity.ok( ProductoDTO.of(productoServicio.actualizar(producto)) );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje(e.getMessage()));
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> borrarProducto(@PathVariable String codigo) throws Exception {
        try{
            productoServicio.eliminar(codigo);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje(e.getMessage()));
        }
    }
    @PatchMapping("/{codigo}/descuentos")
    public ResponseEntity<?> adicionarDescuento(@PathVariable String codigo,@RequestBody DescuentoDTO descuento)  {
        try{
            Producto producto = productoServicio.obtener(codigo);
            float nuevoDescuento = producto.getDescuento() + descuento.getValue();
            producto.setDescuento(nuevoDescuento);
            return ResponseEntity.ok( ProductoDTO.of(productoServicio.actualizar(producto)) );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensaje(e.getMessage()));
        }
    }

}
