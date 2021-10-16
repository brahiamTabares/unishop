package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Administrador extends Persona implements Serializable {


    public Administrador() {
        super();
    }

}
