package co.edu.uniquindio.proyecto.entidades;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


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
public class Compra implements Serializable,EntidadGenerica<String> {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private  String codigo;
    @Column(name="fecha_compra", nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCompra;
    @Enumerated(EnumType.STRING)
    @Column (name="medio_pago", length = 20) // Se indica el nombre de la columna de la base de datoa
    private MedioPago  medioPago;
    @OneToMany (mappedBy = "compra")
    private List<DetalleCompra> detallesCompras;
    @ManyToOne
    @JoinColumn (name="codigo_usuario")
    private Usuario usuario;

    public Compra() {
       super();
    }

    public Compra(String codigo, LocalDateTime fechaCompra, MedioPago medioPago, Usuario usuario) {
        this.codigo = codigo;
        this.fechaCompra = fechaCompra;
        this.medioPago = medioPago;
        this.usuario = usuario;
    }
}
