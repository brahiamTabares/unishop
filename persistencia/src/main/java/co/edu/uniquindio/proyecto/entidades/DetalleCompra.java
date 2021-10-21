package co.edu.uniquindio.proyecto.entidades;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/*
Las etiquetas siguientes son para que con el @Entity lo reconozca como entidad en la base de dato
Las etiquetas @Getter y œSetter son para tener el còdigo màs limpio, se encarga de generar los getters y setter de la clase
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

/*
Se agrega a cada atributo las respectivas restricciones y sus relaciones con otras entidades
 */
public class DetalleCompra implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private  String codigo;
    @Column(nullable = false)
    private Integer unidades;
    @Column(name="precio_producto",nullable = false)
    private Integer precioProducto;
    @ManyToOne
    @JoinColumn(name="codigo_compra",nullable = false)
    private Compra compra;
    @ManyToOne
    @JoinColumn (name="codigo_producto",nullable = false)
    private Producto producto;

    public DetalleCompra() {
       super();
    }
}
