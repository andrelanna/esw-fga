package tests;

//import static org.junit.Assert.*;

import org.junit.Test;

import calculoDeIRPF.Imposto;

public class ImpostoExcecaoTest {

	@Test(expected = Exception.class)
	public void testImpostoComDadosErrados() throws Exception {
		new Imposto(-1, 10, 10);
	}

}
