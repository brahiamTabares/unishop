package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter

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
