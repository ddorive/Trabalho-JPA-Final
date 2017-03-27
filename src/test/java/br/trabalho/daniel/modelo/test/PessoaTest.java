package br.trabalho.daniel.modelo.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Test;

import br.edu.faculdadedelta.base.test.BaseTest;
import br.trabalho.daniel.modelo.Pessoa;
import br.trabalho.daniel.util.JPAUtil;


public class PessoaTest extends BaseTest{

	private static final Logger LOGGER = Logger.getLogger(PessoaTest.class);
	@Test
	public void deveSalvarPessoa() {
		Pessoa pessoa = new Pessoa();
				pessoa.setCpf("111.222.333-44");
				pessoa.setNome("Maria Aparecida");

		assertTrue("não deve ter ID definido", pessoa.isTransient());
		
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
		
		assertFalse("deve ter ID definido", pessoa.isTransient());
	}
	
	
	
	
	@AfterClass
	public static void deveLimparBaseTeste() {
		EntityManager entityManager = JPAUtil.INSTANCE.getEntityManager();
		
		entityManager.getTransaction().begin();
		
		Query query = entityManager.createQuery("DELETE FROM Pessoa p");
		int qtdRegistrosExcluidos = query.executeUpdate();
		
		entityManager.getTransaction().commit();

		assertTrue("Garantindo que a base esta limpa", qtdRegistrosExcluidos > 0);
		
		LOGGER.info("== Base de testes limpada (Tabela Pessoa) ==");
	}

}
