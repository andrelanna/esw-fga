package calculoDeIRPF.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import calculoDeIRPF.Deducao;
import calculoDeIRPF.IRPF;
import calculoDeIRPF.Rendimento;
import calculoDeIRPF.exceptions.DeducaoNulaException;
import calculoDeIRPF.exceptions.DeducaoVaziaException;
import calculoDeIRPF.exceptions.RendimentosNulosException;
import calculoDeIRPF.exceptions.RendimentosVaziosException;
import calculoDeIRPF.IRPF.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IRPFTests {
	static IRPF irpf;
	static Rendimento rendimento;
	static Deducao deducao;
	
	@BeforeClass
	public static void setup() {
		irpf = new IRPF();
		rendimento = new Rendimento("Rendimento", 1);
		deducao = new Deducao("Deducao", 1);
	}
	
	@Test
	public void Test1CadastrarRendimento() {
		boolean value = irpf.cadastrarRendimento(rendimento);
		assertTrue(value);		
	}
	
	@Test
	public void Test2ConsultarRendimento() throws RendimentosNulosException {
		float value = irpf.totalRendimentos();
		assertEquals(value, 1, 0.0f);
	}
	
	@Test
	public void Test3NumDeRendimentos() throws RendimentosNulosException {
		int value = irpf.numRendimentos();
		assertEquals(value, 1);
	}
	
	@Test
	public void Test4GetRendimentos() {
		Object value[] = irpf.getRendimentos();
		assertEquals(value.length, 1);
	}
	
	@Test
	public void Test5CadastrarDeducao() throws DeducaoNulaException {
		boolean value = irpf.cadastrarDedudacao(deducao);
		assertTrue(value);
	}
	
	@Test
	public void Test6TotalDeducao() throws DeducaoVaziaException {
		float value = irpf.totalDeducoes();
		assertEquals(value, 1f, 0.0f);
	}
	
	@Test
	public void Test7NumTotalDeducoes() {
		int value = irpf.numTotalDeducoes();
		assertEquals(value, 1);
	}
	
	@Test
	public void Test8BaseDeCalculo() throws RendimentosVaziosException {
		float value = irpf.calcularBaseDeCalculo();
		assertEquals(value, 0f, 0.0f);
	}	
}
