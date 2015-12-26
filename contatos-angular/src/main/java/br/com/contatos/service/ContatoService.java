package br.com.contatos.service;

import java.util.List;

import br.com.contatos.entity.Contato;

public interface ContatoService {
	
	Contato create(Contato todo);
	 
	void delete(String id);
 
    List<Contato> findAll();
 
    Contato findById(String id);
 
    Contato update(Contato contato);
	
}
