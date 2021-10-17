package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)// Se usa cuando hay herencia entre entidades
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Persona implements Serializable {

    @Id
     @Column(length = 10)
    @EqualsAndHashCode.Include
    private String codigo;
    @Column(nullable = false,length = 50)
    private String nombre;
    @Column(nullable = false,unique = true,length = 120)
    private String email;
    @Column(nullable = false, length = 200)
    private String password;

    public Persona() {
     super();
    }
}
