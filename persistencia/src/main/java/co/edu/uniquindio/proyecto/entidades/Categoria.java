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
public class Categoria implements Serializable {
    @Id
    @Column(nullable = false,length = 10)
    private  String codigo;
    @Column(nullable = false,length = 100)
    private String nombre;

}
