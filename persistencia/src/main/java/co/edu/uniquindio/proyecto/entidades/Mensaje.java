package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mensaje {

    @Id
    @Column(nullable = false,length = 10)
    private String codigo;
    @Column(nullable = false,length = 200)
    private  String mensaje;
    @Column(nullable = false)
    private   String emisor;
    @Column(nullable = false,columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha;



}
