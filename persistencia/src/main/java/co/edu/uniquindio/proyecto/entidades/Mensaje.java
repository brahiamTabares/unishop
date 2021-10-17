package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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
