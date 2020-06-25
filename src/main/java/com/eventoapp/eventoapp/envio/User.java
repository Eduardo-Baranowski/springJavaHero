package com.eventoapp.eventoapp.envio;

public class User {

	  private String nome;
	  private String email;
	  private String telefone;
	  private String descricao;
		
	  public String getNome() {
	    return nome;
	  }
		
	  public void setNome(String nome) {
	    this.nome = nome;
	  }
		
	  public String getEmail() {
	    return email;
	  }
		
	  public void setEmail(String email) {
	    this.email = email;
	  }
	  
	  public String getTelefone() {
		    return telefone;
		  }
			
	  public void setTelefone (String telefone) {
		    this.telefone = telefone;
	  }	  
	  public String getDescricao() {
		    return descricao;
		  }
			
	  public void setDescricao (String descricao) {
		    this.descricao = descricao;
	  }	  
	}