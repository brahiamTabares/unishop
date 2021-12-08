package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/*
Las etiquetas siguientes son para que con el @Entity lo reconozca como entidad en la base de dato
Las etiquetas @Getter y œSetter son para tener el còdigo màs limpio, se encarga de generar los getters y setter de la clase
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

/*
Se agrega a cada atributo las respectivas restricciones y sus relaciones con otras entidades
 */
public class ProductoDTO implements Serializable {
    @EqualsAndHashCode.Include
     private String codigo;
     private String nombre;
    @Positive
     private Integer unidades;
     private String descripcion;
    @Positive
     private float   precio;
     private LocalDate fechaLimite;
    private float descuento;
    private List<CategoriaDTO> categorias;
    private CiudadDTO ciudad;
    private UsuarioDTO vendedor;
    private List<String> imagenes;

    private List<ComentarioDTO> comentarios;

    public static ProductoDTO of(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setCodigo(producto.getCodigo());
        productoDTO.setNombre(producto.getNombre() );
        productoDTO.setUnidades(producto.getUnidades() );
        productoDTO.setDescripcion(producto.getDescripcion() );
        productoDTO.setPrecio(producto.getPrecio() );
        productoDTO.setFechaLimite( producto.getFechaLimite() );
        productoDTO.setDescuento(producto.getDescuento());
        productoDTO.setCategorias( producto.getCategorias().stream().map(CategoriaDTO::of).collect(Collectors.toList()) );
        productoDTO.setCiudad( CiudadDTO.of(producto.getCiudad()) );
        productoDTO.setVendedor( UsuarioDTO.of(producto.getVendedor()) );
        productoDTO.setImagenes(producto.getImagenes());
        if( producto.getComentarios() != null ) {
            productoDTO.setComentarios(producto.getComentarios().stream().map(ComentarioDTO::of).collect(Collectors.toList()));
        }
        return productoDTO;
    }
}
