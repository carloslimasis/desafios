package br.com.contatos.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Contato {

	public Contato() {}
	
	public Contato(Builder builder) {
		this.nome = builder.nome;
		this.telefone = builder.telefone;
		this.cor = builder.cor;
		this.data = builder.data;
		this.operadora = builder.operadora;
	}
	
	@Id
	private String id;
	@Field(value = "nome")
	private String nome;
	@Field(value = "telefone")
	private String telefone;
	@Field(value = "cor")
	private String cor;
	
	@Field(value = "data")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date data;

	@DBRef
	@Field(value = "operadora")
	private Operadora operadora;
	
	public static Builder getBuilder() {
		return new Builder();
	}
	
	public static class Builder {
		
		private Builder(){}
		
		private String nome;
		private String telefone;
		private String cor;
		private Date data;
		private Operadora operadora;
		
		public Builder nome(String nome){
			this.nome = nome;
			return this;
		}
		
		public Builder telefone(String telefone){
			this.telefone = telefone;
			return this;
		}
		
		public Builder cor(String cor){
			this.cor = cor;
			return this;
		}
		
		public Builder data(Date data){
			this.data = data;
			return this;
		}
		
		public Builder operadora(Operadora operadora){
			this.operadora = operadora;
			return this;
		}
		
		public Contato build(){
			return new Contato(this);
		}
	}
	
	public String getCor() {
		return cor;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public Operadora getOperadora() {
		return operadora;
	}
	
	public Date getData() {
		return data;
	}

	public String getId() {
		return id;
	}
}
