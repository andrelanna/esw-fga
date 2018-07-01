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
public class TesteDiv {
	@InjectMocks
	MathApplication mathApplication = new MathApplication();
	
	@Mock
	CalculatorService calcService;
	
	@Test
	public void testeDivDoisNumDiferentesPositivos() {
		mathApplication.setCalcService(calcService);
		
		when(calcService.div(10, 5)).thenReturn(2.0);
		
		assertEquals(2.0, mathApplication.div(10, 5), 0);
	}
	
	@Test(expected=ArithmeticException.class)
	public void testeDivPorZero() {
		mathApplication.setCalcService(calcService);
		
		when(calcService.div(10, 0)).thenThrow(ArithmeticException.class);
		
		mathApplication.div(10, 0);
	}

}
