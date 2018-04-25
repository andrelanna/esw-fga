package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;
import calculoDeIRPF.Deducao;
import calculoDeIRPF.IRPF;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeducaoTest {

	static IRPF irpf; 
	
	@BeforeClass
	public static void setup() {
		irpf = new IRPF();
	}
	
	private String descricaoDeducao;
	private float valorDeducao;
	private float valorTotalDeducoes;
	private int qtdTotalDeducoes;
	
	// Constructor for parameterized test
	public DeducaoTest(String descricao, float valor, float valorTotal, int qtdDeducoes){
		this.descricaoDeducao = descricao;
		this.valorDeducao = valor;
		this.valorTotalDeducoes = valorTotal;
		this.qtdTotalDeducoes = qtdDeducoes;
		
	}
	
	
	@Parameters
	public static Collection<Object[]> data() {
		
		
        return Arrays.asList(new Object[][] {     
                 { "Contribuicao Previdenciaria", 2000f, 2000f, 1 },
                 { "Plano de Saude", 500f, 2500f, 2 },
                 { "Alugel", 1000f, 3500f, 3 },
                 { "Plano dentário", 300f, 3800f, 4 }  
           });
    }
	
	// Parameterized test
	@Test
	public void parameterizedDeducaoTest() {
		Deducao dtest = new Deducao(this.descricaoDeducao, this.valorDeducao);
		
		boolean resposta = irpf.cadastrarDedudacao(dtest);
		assertTrue(resposta); 
		assertEquals(this.valorTotalDeducoes, irpf.totalDeducoes(), 0f);
		assertEquals(this.qtdTotalDeducoes, irpf.numTotalDeducoes());
		
	}

}
