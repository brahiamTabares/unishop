package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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
