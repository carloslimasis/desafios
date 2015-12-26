package br.com.contatos.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "operadoras")
public final class Operadora {

	public Operadora() {}

	public Operadora(Builder builder) {
		this.nome = builder.nome;
		this.codigo = builder.codigo;
		this.categoria = builder.categoria;
		this.preco = builder.preco;
	}
	
	@Id
	private String id;
	private String nome;
	private Integer codigo;
	private String categoria;
	private BigDecimal preco;

	public static Builder getBuilder() {
		return new Builder();
	}
	
	static class Builder {
		
		private Builder(){}
		
		private String nome;
		private Integer codigo;
		private String categoria;
		private BigDecimal preco;
		
		Builder nome(String nome){
			this.nome = nome;
			return this;
		}
		
		Builder codigo(Integer codigo){
			this.codigo = codigo;
			return this;
		}
		
		Builder categoria(String categoria){
			this.categoria = categoria;
			return this;
		}
		
		Builder preco(BigDecimal preco){
			this.preco = preco;
			return this;
			
		}
		
		Operadora build(){
			return new Operadora(this);
		}
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public BigDecimal getPreco() {
		return preco;
	}
}
