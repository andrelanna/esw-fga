package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;

import calculoDeIRPF.IRPF;
import calculoDeIRPF.Rendimento;
import exceptions.RendimentosNulosException;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

import org.junit.Test;
import org.junit.runners.MethodSorters;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@FixMethodOrder(MethodSorters.JVM)
public class RendimentoTest {

	static IRPF irpf;
	
	@BeforeClass
	public static void setup() {
		irpf = new IRPF();
	}
	
	private String descricaoRendimento;
	private float valorRendimento;
	private float valorTotalRendimentos;
	private int qtdTotalRendimentos;
	
	// Constructor for parameterized test
	public RendimentoTest(String descricao, float valor, float valorTotal, int qtdRendimentos){
		this.descricaoRendimento = descricao;
		this.valorRendimento = valor;
		this.valorTotalRendimentos= valorTotal;
		this.qtdTotalRendimentos = qtdRendimentos;
		
	}
	
	
	@Parameters
	public static Collection<Object[]> data() {
		
		
        return Arrays.asList(new Object[][] {     
                 { "Salario", 5000f, 5000f, 1 },
                 { "Alugel", 1000f, 6000f, 2 },
                 { "Mais Rendimento", 1000f, 7000f, 3 },
                 { "Outro Rendimento ", 500f, 7500f, 4 }  
           });
    }
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void test0opasso_AcessarRendimentoNaoCadastrado() {
		Object[] rends = irpf.getRendimentos();
		Object r = rends[9]; // this array doesn't have the 9th element
	}
	
	@Test
	public void parameterizedDeducaoTest() throws RendimentosNulosException {
		Rendimento dtest = new Rendimento(this.descricaoRendimento, this.valorRendimento);
		
		boolean resposta = irpf.cadastrarRendimento(dtest);
		assertTrue(resposta); 
		assertEquals(this.valorTotalRendimentos, irpf.totalRendimentos(), 0f);
		assertEquals(this.qtdTotalRendimentos, irpf.numRendimentos());
		
	}




}
