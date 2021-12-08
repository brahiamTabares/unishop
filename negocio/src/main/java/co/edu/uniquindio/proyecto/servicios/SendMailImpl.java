package co.edu.uniquindio.proyecto.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class SendMailImpl implements SendMail {
    private JavaMailSender sender;

    @Autowired
    public SendMailImpl() {
        this.sender = sender;
    }

    public void enviar(String to, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setTo(to);
            message.setText(text);
            message.setSubject(subject);
            sender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
