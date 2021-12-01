package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.repositorios.PersonaRepo;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeguridadServicioImpl implements SeguridadServicio{

    private PersonaRepo<Persona> personaRepo;
    private JavaMailSender sender;

    public SeguridadServicioImpl(PersonaRepo<Persona> repositorio,JavaMailSender sender) {
        this.personaRepo = repositorio;
        this.sender = sender;
    }

    @Override
    public Persona autenticar(String username, String password) {
        return personaRepo.findByUsernameAndPassword(username,password)
                .orElseThrow( ()->{throw new RuntimeException("Usuario o clave incorrecta");} );
    }

    @Override
    public void recuperar(String email) {
        Optional<Persona> persona = personaRepo.findByEmail(email);
        persona.ifPresentOrElse(this::enviarEmailRecuperacion,()->{throw new RuntimeException("Usuario no registrado");});
    }

    private void enviarEmailRecuperacion(Persona persona){
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setTo(persona.getEmail());
            message.setText("Su clave es:"+persona.getPassword());
            message.setSubject("Recuperación de clave");
            sender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
