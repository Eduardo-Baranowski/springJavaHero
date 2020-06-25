package com.eventoapp.eventoapp;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eventoapp.eventoapp.envio.Mailer;
import com.eventoapp.eventoapp.envio.Mensagem;

public class SpringEmailMain {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringEmailMain.class.getPackage().getName());
		
		Mailer mailer = applicationContext.getBean(Mailer.class);
		mailer.enviar(new Mensagem("Teste <eduardobaranowskiteste@gmail.com>",
				Arrays.asList("Teste <eduardobaranowski@gmail.com>"), "Teste", "Olá" ));
		
		applicationContext.close();
		
		System.out.println("Fim!");
	}
}
