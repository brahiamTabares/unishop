package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;

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
public class SubastaUsuario implements Serializable {

    @Id
    @Column(nullable = false,length = 10)
    @EqualsAndHashCode.Include
    private  String codigo;
    @Column(nullable = false)
    private Integer valor;
    @Future
    @Column(name = "fecha_subasta", nullable = false)
    private LocalDate fechaSubasta;
    @ManyToOne
    @JoinColumn (name = "codigo_subasta", nullable = false)
    private Subasta subasta;

    @ManyToOne
    @JoinColumn (name = "codigo_usuario", nullable = false)
    private Usuario usuario;

    public SubastaUsuario() {

        super();
    }
}
