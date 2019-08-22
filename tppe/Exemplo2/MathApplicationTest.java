package Exemplo2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {

	//Injetar Mocks --> criar e injetar o objeto mock
	@InjectMocks
	MathApplication mathApplication = new MathApplication();
	
	//Criar o objeto mock a ser injetado
	@Mock
	CalculatorService calcService;
	
	@Test
	public void test() {
		mathApplication.setCalcService(calcService);
		
		//adicionar o comportamento do servico de calculo para adicionar dois numeros
		when(calcService.add(10.0, 20.0)).thenReturn(30.0);
		
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0.0);
	}
	
	@Test
	public void testSub(){
		mathApplication.setCalcService(calcService);
		
		//adicionar o comportamento simulado
		when(calcService.sub(10.0, 5.0)).thenReturn(5.0);
		
		Assert.assertEquals(5.0, mathApplication.sub(10.0, 5.0), 0.0);
	}

}
