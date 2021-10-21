package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/*
Las etiquetas siguientes son para que con el @Entity lo reconozca como entidad en la base de dato
Las etiquetas @Getter, @Setter  y Contructor son para tener el còdigo màs limpio, se encarga de generar los getters y setter de la clase
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

/*
Se agrega a cada atributo las respectivas restricciones y sus relaciones con otras entidades
 */
public class Mensaje implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private String codigo;
    @Column(nullable = false,length = 200)
    private  String mensaje;
    @Column(nullable = false, length = 50)
    private   String emisor;
    @Column(nullable = false,columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha;
    @ManyToOne
    @JoinColumn(name="codigo_chat", nullable = false) // Designa la llave foránea
    private Chat chat;

    public Mensaje() {
       super();
    }
}
