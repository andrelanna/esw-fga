package tests;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import calculoDeIRPF.Dependente;
import calculoDeIRPF.IRPF;
import calculoDeIRPF.Rendimento;


@RunWith(Parameterized.class)
public class DependenteTests {

	@Parameter(value = 0)
	public float quantidade;
	
	@Parameter(value = 1)
	public float expected;
	
	public static float rendimento = 10000f;
	
	public IRPF irpf;
	
	@Before
	public void setup(){
		irpf = new IRPF();
	}
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3, (rendimento - 568.77f)},
                {1, (rendimento - 189.59f)},
                {0, rendimento}
        });
    }
	
	@Test
	public void testDependentes() {
		
		irpf.cadastrarRendimento(new Rendimento("Desc", rendimento) );
		
		for(int i = 0; i < quantidade; i++){
			irpf.cadastrarDependente(new Dependente());
		}
		
		try {
			assertEquals(irpf.calcularBaseDeCalculo(), expected, 0.00f);
		} catch(Exception e){
			fail("Test Failed Exception Rendimentos vazios");
		}
		
	}

}
