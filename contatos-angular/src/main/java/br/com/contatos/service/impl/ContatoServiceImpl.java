package br.com.contatos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contatos.entity.Contato;
import br.com.contatos.repository.ContatoRepository;
import br.com.contatos.service.ContatoService;
import br.com.contatos.service.exception.ContatoNotFoundException;

@Service
public class ContatoServiceImpl implements ContatoService {

	private ContatoRepository repository;

	public ContatoServiceImpl() {
	}
	
	@Autowired
	public ContatoServiceImpl(ContatoRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Contato create(Contato contato) {
		Contato contatoPersited = Contato.getBuilder().nome(contato.getNome())
													  .cor(contato.getCor())
													  .data(contato.getData())
													  .operadora(contato.getOperadora())
													  .telefone(contato.getTelefone())
													  .build();
		return repository.save(contatoPersited);
	}

	@Override
    public void delete(String id) {
		Contato deleted = findContatoById(id);
        repository.delete(deleted);
    }
 
    @Override
    public List<Contato> findAll() {
        return repository.findAll();
    }
 
    @Override
    public Contato findById(String id) {
    	return findContatoById(id);
    }
 
    @Override
    public Contato update(Contato contato) {
    	Contato updated = findContatoById(contato.getId());
        return repository.save(updated);
    }
 
    private Contato findContatoById(String id) {
        return repository.findOne(id);
    }
}
