package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/*
Las etiquetas siguientes son para que con el @Entity lo reconozca como entidad en la base de dato
Las etiquetas @Getter y œSetter son para tener el còdigo màs limpio, se encarga de generar los getters y setter de la clase
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

/*
Se agrega a cada atributo las respectivas restricciones y sus relaciones con otras entidades
 */
public class Chat implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false,length = 10)
    private  String codigo;
    @ManyToOne
    @JoinColumn (name="codigo_usuario")// Para designar el nombre de la llave foránea
    private Usuario usuario;
    @OneToMany (mappedBy = "chat") // Permite establecer que esa variable ya existe en la clase Mensaje con la variable chat
    private List<Mensaje> mensajes;

    public Chat() {}

    public Chat(String codigo, Usuario usuario) {
        this.codigo = codigo;
        this.usuario = usuario;
    }
}
