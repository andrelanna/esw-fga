package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import calculoDeIRPF.Deducao;
import calculoDeIRPF.IRPF;
import calculoDeIRPF.Imposto;
import calculoDeIRPF.exceptions.ImpostoNuloException;
import calculoDeIRPF.exceptions.RendimentosNulosException;

public class ImpostoTest {
	
	static IRPF irpf; 
	
	@BeforeClass
	public static void setup() {
		irpf = new IRPF();
	}

	@Test(expected= RendimentosNulosException.class)
	public void testCalculoImpostoSemRendimentos() throws ImpostoNuloException, RendimentosNulosException {
		irpf.calculaImposto();
	}

	
}
