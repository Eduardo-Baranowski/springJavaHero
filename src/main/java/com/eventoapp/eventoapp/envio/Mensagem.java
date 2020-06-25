package com.eventoapp.eventoapp.envio;

public class Mensagem {
	private String remetente;
	
	private java.util.List<String> destinatarios;
	

	private String assunto;
	private String corpo;
	
	public Mensagem(String remetente, java.util.List<String> destinatarios, String assunto, String corpo) {
		this.remetente = remetente;
		this.destinatarios = destinatarios;
		this.assunto = assunto;
		this.corpo = corpo;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public java.util.List<String> getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(java.util.List<String> destinatarios) {
		this.destinatarios = destinatarios;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	

}
