package br.com.contatos.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.contatos.entity.Contato;

public interface ContatoRepository extends MongoRepository<Contato, String> {
	void delete(Contato contato);
	List<Contato> findAll();
	Contato findOne(String id);
	Contato save(Contato contato);
}
