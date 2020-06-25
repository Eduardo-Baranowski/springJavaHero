package com.eventoapp.eventoapp.envio;

import java.io.ObjectInputStream.GetField;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;



public class JavaMailApp
{
  
	@Autowired private static String nome;
	@Autowired private static String email;
	@Autowired private static String telefone;
	@Autowired private static String descricao;

public JavaMailApp(){
	  
  }
  
  public JavaMailApp(String nome, String email, String telefone, String descricao){
	   this.nome= nome;
	   this.email = email;
	   this.telefone = telefone;
	   this.descricao = descricao;
	}

public static String getNome() {
	return nome;
}

public static void setNome(String nome) {
	JavaMailApp.nome = nome;
}

public static String getEmail() {
	return email;
}

public static void setEmail(String email) {
	JavaMailApp.email = email;
}

public static String getTelefone() {
	return telefone;
}

public static void setTelefone(String telefone) {
	JavaMailApp.telefone = telefone;
}

public static String getDescricao() {
	return descricao;
}

public static void setDescricao(String descricao) {
	JavaMailApp.descricao = descricao;
}

public static void main(String[] args) {
	JavaMailApp javaMail = new JavaMailApp("Edu", "Edu@edu", "123", "descricao");
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", 
    "javax.net.ssl.SSLSocketFactory");
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
      message.setFrom(new InternetAddress("seuemail@gmail.com")); 
 
      Address[] toUser = InternetAddress
                 .parse("eduardobaranowski@gmail.com");  
 
      message.setRecipients(Message.RecipientType.TO, toUser);
      message.setSubject("Enviando email com JavaMail");
      message.setText(nome+ email + telefone + descricao);
      Transport.send(message);
 
      System.out.println("Feito!!!");
 
     } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
  }


    
}