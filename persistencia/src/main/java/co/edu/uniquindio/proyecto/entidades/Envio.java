package co.edu.uniquindio.proyecto.entidades;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Envio {

    @Id
    @Column(length = 10)
    @EqualsAndHashCode.Include
    private String codigo;
    @Column(name="fecha_Envio",nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaEmvio;

    @Column(length = 20)
    private String   NombreEmpraTransporta;
    @Column(length = 20)
    private String direccionOrigen;
    @Column(length = 20)
    private String direccionDestino;
    @OneToOne
    private Compra compra;


    public Envio() {
        super();
    }



}
