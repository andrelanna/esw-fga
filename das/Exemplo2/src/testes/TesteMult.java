package testes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import exemplo2.CalculatorService;
import exemplo2.MathApplication;

@RunWith(MockitoJUnitRunner.class)
public class TesteMult {
	@InjectMocks
	MathApplication mathApplication = new MathApplication();
	
	@Mock
	CalculatorService calcService;
	
	@Test
	public void testeMultDoisNumerosPositivos() {
		mathApplication.setCalcService(calcService);
		
		when(calcService.mult(10, 9)).thenReturn(90.0);
		
		assertEquals(90.0, mathApplication.mult(10, 9), 0);
	} 
	
	@Test
	public void testeMultDoisNumerosNegativos() {
		mathApplication.setCalcService(calcService);
		
		when(calcService.mult(-1, -1)).thenReturn(1.0);
		
		assertEquals(1.0, mathApplication.mult(-1, -1), 0);
	}
}
