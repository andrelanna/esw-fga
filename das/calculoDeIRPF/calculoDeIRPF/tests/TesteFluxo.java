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

	public static IRPF irpf;
	
	@Mock
    Dependente dependente;
	
	
	@BeforeClass
	public static void setup() {
		irpf = new IRPF();
	}
	
	@Test
	public void teste01AdicionaRendimento() throws RendimentosNulosException {
		Rendimento r = new Rendimento("rendimento1", 1000.0f);
		
		boolean resposta = irpf.cadastrarRendimento(r);
		assertTrue(resposta); 
		assertEquals(1000f, irpf.totalRendimentos(), 0.1f);
		assertEquals(1, irpf.numRendimentos());
	}

	@Test
	public void teste02AdicionaDependente() {
		boolean resposta = irpf.adicionarDependente(this.dependente);
		assertTrue(resposta);
		assertEquals(189.5, irpf.totalDependentes(), 0.1f);
		assertEquals(1, irpf.getDependentes().size());
	}
	
	@Test
	public void teste03AdicionaDeducao() {
		Deducao d = new Deducao("Deducao1", 100f);
		
		boolean resposta = irpf.cadastrarDedudacao(d);
		assertTrue(resposta); 
		assertEquals(100f, irpf.totalDeducoes(), 0.1f);
		assertEquals(1, irpf.numTotalDeducoes());
	}
	
	@Test
	public void teste04BaseDeCalculo() throws RendimentosVaziosException, RendimentosNulosException {
		irpf.calcularBaseDeCalculo();
		assertEquals(710.41f, irpf.getBaseDeCalculo(), 0.1f);
		for(int i = 0; i < 5; i++) {
			assertEquals(0.0f, irpf.getImpostos().get(i).getValorImposto(), 0.1f);
		}
	}
	
	@Test
	public void teste05CalculoImposto() throws RendimentosVaziosException, RendimentosNulosException {
		//TODO Fazer o teste que calcula imposto
	}

}
