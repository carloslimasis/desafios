package br.com.contatos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.contatos.entity.Contato;
import br.com.contatos.service.ContatoService;
import br.com.contatos.service.exception.ContatoNotFoundException;

@RestController
@RequestMapping("/api/contato")
public final class ContatoController {
	
	private final ContatoService service;
	 
    @Autowired
    public ContatoController(ContatoService service) {
        this.service = service;
    }
 
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Contato create(@RequestBody @Valid Contato contatoEntry) {
        return service.create(contatoEntry);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }
 
    @RequestMapping(method = RequestMethod.GET)
    List<Contato> findAll() {
        return service.findAll();
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Contato findById(@PathVariable("id") String id) {
        return service.findById(id);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Contato update(@RequestBody @Valid Contato todoEntry) {
        return service.update(todoEntry);
    }
 
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(ContatoNotFoundException ex) {
    }
}
