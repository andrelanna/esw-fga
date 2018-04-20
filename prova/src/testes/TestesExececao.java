package testes;

import org.junit.Test;

import excecoes.BandeiraException;
import excecoes.KMException;
import models.Corrida;

public class TestesExececao {

	@Test(expected=BandeiraException.class)
	public void testeExcecaoBandeira() throws BandeiraException, KMException {
		Corrida corrida = new Corrida();
		corrida.calculaTarifa(null, 10.0, 5.0);
	}
	
	@Test(expected=KMException.class)
	public void testeExcecaoKM() throws BandeiraException, KMException  {
		Corrida corrida = new Corrida();
		corrida.calculaTarifa("Bandeira 1", 0, 10.0);
	}
}
