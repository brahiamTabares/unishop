package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.Setter;

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

/*
Se agrega a cada atributo las respectivas restricciones y sus relaciones con otras entidades
 */
public class Usuario extends Persona { // No requiere serializable por venir de Herencia

    @ManyToOne
    @JoinColumn(name="codigo_ciudad") // Designa llave foránea
    private Ciudad ciudad;
    @OneToMany (mappedBy = "usuario") // indica que la relaciòn existe con la variable usuario en la Clase Comentario
    private List<Comentario> comentarios;
    @OneToMany (mappedBy = "usuario")
    private List<Compra> compras;
    @OneToMany (mappedBy = "vendedor")
    private List<Producto> productos;

    @ManyToMany(mappedBy = "usuarios")
    private List<Producto>productosFavoritos;

    @OneToMany (mappedBy = "usuario")
    private List<SubastaUsuario> subastas;
    @ElementCollection
    @CollectionTable (name = "Telefono", joinColumns = @JoinColumn(name="codigo_usuario", nullable = false))
    @Column (name="num_telefono")
    private List<String> telefonos;
    @OneToMany (mappedBy = "usuario")
    private List<Chat> chats;

    public Usuario() {
        super();
    }

    public Usuario(String codigo, String nombre, String email, String password, Ciudad ciudad,List<String> telefonos) {
        super(codigo, nombre, email, password);
        this.ciudad = ciudad;
        this.telefonos = telefonos;
    }
}
