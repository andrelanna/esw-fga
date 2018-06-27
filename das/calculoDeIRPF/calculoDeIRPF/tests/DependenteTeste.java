package calculoDeIRPF.tests;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import calculoDeIRPF.Dependente;
import calculoDeIRPF.DependenteService;

import org.mockito.InjectMocks;
import org.mockito.Mock;
@RunWith(MockitoJUnitRunner.class)
public class DependenteTeste {
	@InjectMocks
	Dependente dependente = new Dependente();
	@Mock
	DependenteService ds;
	
	@Test
	public void testDeducao() {
		dependente.setService(ds);
		
		when(ds.deducao()).thenReturn(189.59f);
		
		assertEquals(dependente.deducao(),189.59f,0.0f);
	}
}
