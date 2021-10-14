package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    public Persona(String codigo, String nombre, String email, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }
}
