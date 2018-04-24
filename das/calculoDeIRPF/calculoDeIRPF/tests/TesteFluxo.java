package calculoDeIRPF.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;

import calculoDeIRPF.Deducao;
import calculoDeIRPF.Dependente;
import calculoDeIRPF.IRPF;
import calculoDeIRPF.Rendimento;
import calculoDeIRPF.exceptions.RendimentosNulosException;
import calculoDeIRPF.exceptions.RendimentosVaziosException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteFluxo {

	public static IRPF contribuinte1;
	public static IRPF contribuinte2;

	@Mock
    Dependente dependente;
	
	
	@BeforeClass
	public static void setup() {
		contribuinte1 = new IRPF();
		contribuinte2 = new IRPF();
	}
	
	@Test
	public void teste01AdicionaRendimento() throws RendimentosNulosException {
		Rendimento r = new Rendimento("rendimento1", 1000.0f);
		
		boolean resposta = contribuinte1.cadastrarRendimento(r);
		assertTrue(resposta); 
		assertEquals(1000f, contribuinte1.totalRendimentos(), 0.1f);
		assertEquals(1, contribuinte1.numRendimentos());
	}

	@Test
	public void teste02AdicionaDependente() {
		boolean resposta = contribuinte1.adicionarDependente(this.dependente);
		assertTrue(resposta);
		assertEquals(189.5, contribuinte1.totalDependentes(), 0.1f);
		assertEquals(1, contribuinte1.getDependentes().size());
	}
	
	@Test
	public void teste03AdicionaDeducao() {
		Deducao d = new Deducao("Deducao1", 100f);
		
		boolean resposta = contribuinte1.cadastrarDedudacao(d);
		assertTrue(resposta); 
		assertEquals(100f, contribuinte1.totalDeducoes(), 0.1f);
		assertEquals(1, contribuinte1.numTotalDeducoes());
	}
	
	@Test
	public void teste04BaseDeCalculo() throws RendimentosVaziosException, RendimentosNulosException {
		contribuinte1.calcularBaseDeCalculo();
		assertEquals(710.41f, contribuinte1.getBaseDeCalculo(), 0.1f);
		for(int i = 0; i < 5; i++) {
			assertEquals(0.0f, contribuinte1.getImpostos().get(i).getValorImposto(), 0.1f);
		}
	}
	
	@Test
	public void teste05CalculoImposto() throws RendimentosVaziosException, RendimentosNulosException {
		double imposto = contribuinte1.totalImposto();
		
		assertEquals(0.0f, imposto, 0.0f);
	}
		
	@Test
	public void teste06QuantidadeContribuintes() throws RendimentosVaziosException, RendimentosNulosException {		
		IRPF.contribuintes.add(contribuinte1);
		IRPF.contribuintes.add(contribuinte2);
		assertEquals(2, IRPF.contribuintes.size());
	}

}
