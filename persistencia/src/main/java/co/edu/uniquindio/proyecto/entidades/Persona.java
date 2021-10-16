package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Persona implements Serializable {

    @Id
     @Column(length = 10)
    @EqualsAndHashCode.Include
    private String codigo;
    @Column(nullable = false,length = 100)
    private String nombre;
    @Column(nullable = false,unique = true,length = 120)
    private String email;
    @Column(nullable = false,unique = true)
    private String password;

    public Persona() {
     super();
    }
}
