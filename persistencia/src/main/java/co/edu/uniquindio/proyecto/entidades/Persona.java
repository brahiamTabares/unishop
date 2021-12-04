package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
/*
Las etiquetas siguientes son para que con el @Entity lo reconozca como entidad en la base de dato
Las etiquetas @Getter y œSetter son para tener el còdigo màs limpio, se encarga de generar los getters y setter de la clase
 */
@Entity
@Inheritance (strategy = InheritanceType.JOINED)// Se usa cuando hay herencia entre entidades
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

/*
Se agrega a cada atributo las respectivas restricciones y sus relaciones con otras entidades
 */
public class Persona implements Serializable,EntidadGenerica<String> {

    @Id
     @Column(length = 36)
    @EqualsAndHashCode.Include
    private String codigo;
    @Column(nullable = false,length = 50)
    private String nombre;
    @Column(nullable = false,unique = true,length = 300)
    private String email;
    @Column(nullable = false, length = 200)
    private String password;
    @Column(nullable = false, length = 200)
    private String username;

    public Persona() {
     super();
    }
}
