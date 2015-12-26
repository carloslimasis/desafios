package br.com.contatos.test;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.contatos.entity.Contato;
import br.com.contatos.repository.ContatoRepository;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ContatoRepositoryTest {

	@Autowired ContatoRepository repository;
	
	@Test
    public void readsContatosCorrectly() {

     List<Contato> contatos = repository.findAll();
      Assert.assertThat(contatos.isEmpty(), CoreMatchers.is(false));
    }
}
