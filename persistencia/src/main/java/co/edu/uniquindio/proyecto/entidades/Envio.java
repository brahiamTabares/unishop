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
public class Envio implements Serializable, EntidadGenerica<String>{

    @Id
    @Column(length = 10)
    @EqualsAndHashCode.Include
    private String codigo;
    @Column(name="fecha_Envio",nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaEnvio;

    @Column(length = 100)
    private String direccionOrigen;
    @Column(length = 100)
    private String direccionDestino;
    @OneToOne
    private Compra compra;
    @ManyToOne
    private Transportadora transportadora;


    public Envio() {
        super();
    }



}
