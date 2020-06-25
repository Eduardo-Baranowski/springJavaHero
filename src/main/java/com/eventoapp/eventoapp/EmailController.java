package com.eventoapp.eventoapp;


import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.eventoapp.eventoapp.envio.JavaMailApp;
import com.eventoapp.eventoapp.envio.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/register")
public class EmailController
{
	
  static String nome;
  static String email;
  static String telefone;
  static String descricao;
  
 
  @RequestMapping(method = POST)
  public String processForm(
      User user, Model model) {
		
    nome = model.addAttribute("nome", user.getNome()).toString();
    email = model.addAttribute("email", user.getEmail()).toString();
    telefone = model.addAttribute("telefone", user.getTelefone()).toString();
    descricao = model.addAttribute("descricao", user.getDescricao()).toString();
    
    //JavaMailApp javaMail = new JavaMailApp(nome, email, telefone, descricao);
    
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    //props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");
 
    Session session = Session.getDefaultInstance(props,
      new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() 
           {
                 return new PasswordAuthentication("eduardobaranowskiteste@gmail.com", 
                 "12345678br");
           }
      });
 
    session.setDebug(true);
 
    try {
 
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("eduardobaranowskiteste@gmail.com"));
      Address[] toUser = InternetAddress
                 .parse("eduardobaranowski@gmail.com");  
 
      message.setRecipients(Message.RecipientType.TO, toUser);
      message.setSubject("Email enviado para contato Chess Master");
      message.setText(descricao.toString());
      //message.setText("Nome:" + nome.toString() + "\n" + "Email: " + email.toString() + "\n" + "Telefone: " + telefone.toString() + "\n" + "Descricao: " + descricao.toString());
      Transport.send(message);
 
     } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
    
    return "index";
		
  }	
}